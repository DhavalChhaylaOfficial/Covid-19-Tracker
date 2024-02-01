package com.example.covid_19tracker;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Model> dataList;
    private List<Model> filteredDataList;
    private ListView listView;
    private Adapter adapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();
        filteredDataList = new ArrayList<>();
        listView = findViewById(R.id.listView);
        searchView = findViewById(R.id.searchView);

        adapter = new Adapter(this, filteredDataList);
        listView.setAdapter(adapter);

        fetchData();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterData(newText);
                return true;
            }
        });
    }

    private void fetchData() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://data.covid19india.org/state_district_wise.json";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Iterator<String> stateIterator = response.keys();
                            while (stateIterator.hasNext()) {
                                String stateName = stateIterator.next();
                                JSONObject stateObject = response.getJSONObject(stateName);

                                JSONObject districtData = stateObject.getJSONObject("districtData");

                                Iterator<String> districtIterator = districtData.keys();
                                while (districtIterator.hasNext()) {
                                    String districtName = districtIterator.next();
                                    JSONObject districtObject = districtData.getJSONObject(districtName);

                                    int confirmedCases = districtObject.getInt("confirmed");
                                    int activeCases = districtObject.getInt("active");
                                    int recoveredCases = districtObject.getInt("recovered");
                                    int deceasedCases = districtObject.getInt("deceased");

                                    Model model = new Model(districtName, confirmedCases, activeCases, recoveredCases, deceasedCases);
                                    dataList.add(model);
                                    filteredDataList.add(model);
                                }
                            }

                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        queue.add(jsonObjectRequest);
    }

    private void filterData(String query) {
        filteredDataList.clear();

        if (TextUtils.isEmpty(query)) {
            filteredDataList.addAll(dataList);
        } else {
            query = query.toLowerCase();

            for (Model model : dataList) {
                if (model.getDistrictName().toLowerCase().contains(query)) {
                    filteredDataList.add(model);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }
}



package com.example.covid_19tracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private Context context;
    private List<Model> dataList;

    public Adapter(Context context, List<Model> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.districtNameTextView = convertView.findViewById(R.id.districtNameTextView);
            viewHolder.confirmedCasesTextView = convertView.findViewById(R.id.confirmedCasesTextView);
            viewHolder.activeCasesTextView = convertView.findViewById(R.id.activeCasesTextView);
            viewHolder.recoveredCasesTextView = convertView.findViewById(R.id.recoveredCasesTextView);
            viewHolder.deceasedCasesTextView = convertView.findViewById(R.id.deceasedCasesTextView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Model model = dataList.get(position);

        viewHolder.districtNameTextView.setText("District: " + model.getDistrictName());
        viewHolder.confirmedCasesTextView.setText("ConfirmedCases: " + String.valueOf(model.getConfirmedCases()));
        viewHolder.activeCasesTextView.setText("ActiveCases: " + String.valueOf(model.getActiveCases()));
        viewHolder.recoveredCasesTextView.setText("RecoveredCases: " + String.valueOf(model.getRecoveredCases()));
        viewHolder.deceasedCasesTextView.setText("DeceasedCases: " + String.valueOf(model.getDeceasedCases()));

        return convertView;
    }

    private static class ViewHolder {
        TextView districtNameTextView;
        TextView confirmedCasesTextView;
        TextView activeCasesTextView;
        TextView recoveredCasesTextView;
        TextView deceasedCasesTextView;
    }
}



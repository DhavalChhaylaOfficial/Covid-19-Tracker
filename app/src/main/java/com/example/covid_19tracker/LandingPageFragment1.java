package com.example.covid_19tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LandingPageFragment1 extends Fragment {

    private View bulletPoint1;
    private View bulletPoint2;
    private View bulletPoint3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash1, container, false);


        // Get reference to the button in the fragment layout
        //Button button = view.findViewById(R.id.button);

        // Set a click listener for the button
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Handle button click event
//                Toast.makeText(getActivity(), "Button clicked on Landing Page 1", Toast.LENGTH_SHORT).show();
//            }
//        });
//
        return view;
    }
}

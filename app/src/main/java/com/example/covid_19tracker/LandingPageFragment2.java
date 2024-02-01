package com.example.covid_19tracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LandingPageFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash2, container, false);

        // Get reference to the TextView in the fragment layout
//        TextView textView = view.findViewById(R.id.textView);

        // Set text or customize the TextView as needed
        //textView.setText("Welcome to Landing Page 2");

        return view;
    }
}

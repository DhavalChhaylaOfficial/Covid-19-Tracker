package com.example.covid_19tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LandingPageFragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.splash3, container, false);

        Button btn = view.findViewById(R.id.started);
        btn.setOnClickListener(v -> {
            startActivity(new Intent(getContext(), MainActivity.class));
        });

        // Get reference to the ImageView in the fragment layout
        //ImageView imageView = view.findViewById(R.id.imageView);

        // Set image or customize the ImageView as needed
        //imageView.setImageResource(R.drawable.my_image);

        return view;
    }
}

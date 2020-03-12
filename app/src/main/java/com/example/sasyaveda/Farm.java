package com.example.sasyaveda;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Farm extends Fragment implements View.OnClickListener {


    public Farm() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_farm, container, false);

        CardView cropSuggestion=v.findViewById(R.id.crop_suggestion);
        cropSuggestion.setOnClickListener(this);
        CardView plan=v.findViewById(R.id.crop_plan);
        plan.setOnClickListener(this);
        CardView manure=v.findViewById(R.id.manure);
        manure.setOnClickListener(this);
        CardView method=v.findViewById(R.id.farm_methods);
        method.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.crop_suggestion:
                // do your code
                startActivity(new Intent(getContext(),CropSuggestion.class));
                break;

            case R.id.crop_plan:
                // do your code
                startActivity(new Intent(getContext(),CropPlan.class));
                break;

            case R.id.manure:
                // do your code
                startActivity(new Intent(getContext(),ManurePrep.class));
                break;
            case R.id.farm_methods:
                // do your code
                startActivity(new Intent(getContext(),Next.class));
                break;

            default:
                break;
        }

    }
}

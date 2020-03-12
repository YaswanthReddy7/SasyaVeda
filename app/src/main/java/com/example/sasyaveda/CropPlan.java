package com.example.sasyaveda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CropPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_plan);
    }

    public void cropSuggestion(View view) {
        startActivity(new Intent(this,CropSuggestion.class));
        finish();
    }
}

package com.example.sasyaveda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ManurePrep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manure_prep);
    }

    public void postCompost(View view) {
        Intent in=new Intent(this,ManurePrep2.class);
        in.putExtra("Text",1);
        startActivity(in);
    }

    public void vermiCompost(View view) {
        Intent in=new Intent(this,ManurePrep2.class);
        in.putExtra("Text",2);
        startActivity(in);

    }

    public void bokashi(View view) {
        Intent in=new Intent(this,ManurePrep2.class);
        in.putExtra("Text",3);
        startActivity(in);

    }

    public void eggshell(View view) {

        Intent in=new Intent(this,ManurePrep2.class);
        in.putExtra("Text",4);
        startActivity(in);

    }
}

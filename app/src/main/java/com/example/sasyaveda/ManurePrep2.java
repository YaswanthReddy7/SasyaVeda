package com.example.sasyaveda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ManurePrep2 extends AppCompatActivity {
    int j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manure_prep2);
        Intent in=getIntent();
        Bundle b =in.getExtras();
        if (b!=null){
             j= (int) b.get("Text");
        }
        TextView txt=findViewById(R.id.textView);
        //txt.setText(" "+j);
        switch (j){
            case 1:
                txt.setText("postCompost");
                break;
            case 2:
                txt.setText("postCompost2");
                break;
            case 3:
                txt.setText("postCompost3");
                break;
            case 4:
                txt.setText("postCompost4");
                break;

        }
    }
}

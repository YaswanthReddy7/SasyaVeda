package com.example.sasyaveda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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
        TextView txt=findViewById(R.id.textview);
        TextView movtxt=findViewById(R.id.movingtext);
        movtxt.setSelected(true);

        txt.setMovementMethod(new ScrollingMovementMethod());
        //txt.setText(" "+j);
        String pc=getString(R.string.POSTCOMPOST);
        String vc=getString(R.string.VERMICOMPOST);
        String bok=getString(R.string.THIRD_METHOD);
        String egg=getString(R.string.EGGSHELL);
        switch (j){
            case 1:
                txt.setText(pc);
                movtxt.setText("POT COMPOSTING PREPARATION METHOD");
                break;
            case 2:
                txt.setText(vc);
                movtxt.setText("VERMICOMPOSTING PREPARATION METHOD");
                break;
            case 3:
                txt.setText(bok);
                movtxt.setText("THE BOKASHI METHOD PREPARATION PROCESS");
                break;
            case 4:
                txt.setText(egg);
                movtxt.setText("EGG SHELL MANURE PREPARATION METHOD");
                break;

        }
    }
}

package com.example.sasyaveda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class CropSuggestion extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner reg,pres,nex;
    RadioButton red,black,high,mod,low;
    String soil,water,choice,seas;
    LinearLayout l1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_suggestion);
        reg=findViewById(R.id.region);
        pres=findViewById(R.id.present);
        nex=findViewById(R.id.nextcrop);
        red=findViewById(R.id.red);
        black=findViewById(R.id.black);
        high=findViewById(R.id.high);
        mod=findViewById(R.id.moderate);
        low=findViewById(R.id.low);
        reg.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String dis=String.valueOf(reg.getSelectedItem());
        if (dis.contentEquals("KURNOOL")){
            if (choice.contentEquals("KHBL")) {
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_BLACK_LOW_KHARIF, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("KHBM")){
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_BLACK_MOD_KHARIF, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("KHBH")){
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_BLACK_HIGH_KHARIF, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("KHRL")) {
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_RED_LOW_KHARIF, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("KHRM")){
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_RED_MOD_KHARIF, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("KHRH")){
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_RED_HIGH_KHARIF, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("RABL")){
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_BLACK_LOW_RABI, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("RABM")){
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_BLACK_MOD_RABI, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("RABH")){
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_BLACK_HIGH_RABI, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("RARL")){
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_RED_LOW_RABI, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("RARM")){
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_RED_MOD_RABI, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
            else if (choice.contentEquals("RARH")){
                ArrayAdapter<CharSequence> district = ArrayAdapter.createFromResource(this, R.array.KUR_RED_HIGH_RABI, R.layout.support_simple_spinner_dropdown_item);
                pres.setAdapter(district);
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void manualSelection(View view) {

        startActivity(new Intent(this,CropPlan.class));
        finish();

    }

    public void goforCropPlan(View view) {
        Toast.makeText(this, ""+soil+water, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.black:
                if (checked)
                    // Pirates are the best
                    soil="B";
                    break;
            case R.id.red:
                if (checked)
                    // Ninjas rule
                    soil="R";
                    break;
        }
    }

    public void onRadioButtonClicked2(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {

            case R.id.low:
                if (checked)
                    water="L";
                break;
            case R.id.moderate:
                if (checked)
                    water="M";
                break;
            case R.id.high:
                if (checked)
                    water="H";
                break;

        }
        choice=seas+soil+water;
        Toast.makeText(this, ""+choice, Toast.LENGTH_SHORT).show();

    }

    public void onRadioButtonClicked3(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.kharif:
                if (checked)
                    // Pirates are the best
                    seas="KH";
                break;
            case R.id.rabi:
                if (checked)
                    // Ninjas rule
                    seas="RA";
                break;
        }

    }
}

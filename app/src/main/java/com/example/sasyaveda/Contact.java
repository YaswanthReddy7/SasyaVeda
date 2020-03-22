package com.example.sasyaveda;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        TextView tv=findViewById(R.id.tserv);
        tv.setSelected(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void makeaCall(View view) {
        Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7995401096"));
        if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        startActivity(intentCall);
    }
}

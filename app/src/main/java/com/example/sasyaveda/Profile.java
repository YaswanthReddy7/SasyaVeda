package com.example.sasyaveda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
TextView proname,propassword,pronumber,promail;
DatabaseReference pref;
FirebaseAuth pauth;
String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        proname=findViewById(R.id.pname);
        pronumber=findViewById(R.id.pnum);
        propassword=findViewById(R.id.ppass);
        promail=findViewById(R.id.pmail);
        pref= FirebaseDatabase.getInstance().getReference();
        pauth=FirebaseAuth.getInstance();
        userid=pauth.getUid();
        pref.child("FARMER").orderByChild(userid)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                            String namep=dataSnapshot1.child("userName").getValue().toString();
                            proname.setText(namep);
                            String mailp=dataSnapshot1.child("userMail").getValue().toString();
                            promail.setText(mailp);
                            String passwordp=dataSnapshot1.child("userPassword").getValue().toString();
                            propassword.setText(passwordp);
                            String numberp=dataSnapshot1.child("userPhone").getValue().toString();
                            pronumber.setText(numberp);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

    }
}

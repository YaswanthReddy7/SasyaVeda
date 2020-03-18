package com.example.sasyaveda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText newmail,newpassword,newname,newnumber;
    private FirebaseAuth rAuth;
    DatabaseReference myref;
    DataModel dmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        newmail=findViewById(R.id.rmail);
        newpassword=findViewById(R.id.rpass);
        newname=findViewById(R.id.rname);
        newnumber=findViewById(R.id.rphn);
        myref= FirebaseDatabase.getInstance().getReference();
        rAuth=FirebaseAuth.getInstance();
        dmodel=new DataModel();
    }

    public void userSignUp(View view) {

        final String rmailid=newmail.getText().toString();
        final String rpassword=newpassword.getText().toString();
        final String rname=newname.getText().toString();
        final String rphn=newnumber.getText().toString();
        if (TextUtils.isEmpty(rmailid)){

            newmail.setError("Email is required");
            return;
        }
        if (TextUtils.isEmpty(rpassword)){

            newpassword.setError("Password is required");
            return;
        }
        if (TextUtils.isEmpty(rname)){

            newname.setError("Name required");
            return;
        }
        if (TextUtils.isEmpty(rphn)){

            newnumber.setError("Phone number required");
            return;
        }

        rAuth.createUserWithEmailAndPassword(rmailid,rpassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            
                            dmodel=new DataModel(rmailid,rpassword,rname,rphn);
                            myref.child("FARMER").child(rAuth.getUid()).setValue(dmodel)
                                    .addOnCompleteListener(Register.this, new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){

                                                Toast.makeText(Register.this, "DETAILS STORED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                                            }
                                            else {
                                                Toast.makeText(Register.this, "FAILED", Toast.LENGTH_SHORT).show();
                                            }
                                            
                                        }
                                    });
                            startActivity(new Intent(Register.this,Login.class));
                            finish();
                        }
                        else {

                            Toast.makeText(Register.this, ""+task.getException().getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });


    }
}

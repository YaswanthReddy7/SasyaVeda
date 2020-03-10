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
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText usermail,userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        usermail=findViewById(R.id.email);
        userPassword=findViewById(R.id.epass);
//        newmail=findViewById(R.id.remail);
//        newpassword=findViewById(R.id.rpass);


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user=mAuth.getCurrentUser();
        if (user != null){

            String name=user.getDisplayName();
            String email=user.getEmail();
//            Toast.makeText(this,name+"\n"+email, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,MainActivity.class));
        }
    }

    public void userSignIn(View view) {

        String smail=usermail.getText().toString();
        String spassword=userPassword.getText().toString();
        if (TextUtils.isEmpty(smail)){
            usermail.setError("Email required");
            return;
        }
        if (TextUtils.isEmpty(spassword)){
            userPassword.setError("Password required");
            return;
        }

        mAuth.signInWithEmailAndPassword(smail,spassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);

                }
                else {

                    Toast.makeText(Login.this, ""+task.getException().getMessage().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    public void forgotPassword(View view) {
        if (TextUtils.isEmpty(usermail.getText().toString())){

            usermail.setError("Email is required");
            return;
        }

        mAuth.sendPasswordResetEmail(usermail.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {


                        if (task.isSuccessful()){

                            Toast.makeText(Login.this, "Please check your email", Toast.LENGTH_SHORT).show();
                        }
                        else {

                            Toast.makeText(Login.this, "User not found", Toast.LENGTH_SHORT).show();
                        }

                    }
                });



    }

    public void regScreen(View view) {

        startActivity(new Intent(this,Register.class));

    }
}

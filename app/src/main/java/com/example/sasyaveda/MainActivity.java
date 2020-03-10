package com.example.sasyaveda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TabLayout tb;
    ViewPager vp;
    private FirebaseAuth kauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=findViewById(R.id.tab);
        vp=findViewById(R.id.vpage);
        TabAdapter ta=new TabAdapter(getSupportFragmentManager());
        ta.addFragment(new News(),"NEWS");
        ta.addFragment(new Farm(),"FARM");
        ta.addFragment(new Cart(),"CART");
       // Login lg=new Login();
        vp.setAdapter(ta);
        tb.setupWithViewPager(vp);
        kauth=FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }



        @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.next:
                startActivity(new Intent(this,Notification.class));
                break;
            case R.id.profile:
                startActivity(new Intent(this,Profile.class));
                break;
            case R.id.contact:
                startActivity(new Intent(this,Contact.class));
                break;
            case R.id.logout:

                kauth.signOut();
                startActivity(new Intent(this,Login.class));
                break;



        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);

    }

}

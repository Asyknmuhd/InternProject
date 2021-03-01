package com.example.mptsewa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class SettingActivity extends AppCompatActivity {

    private Button aboutus,profile1,changepass,contact,location,terms,logout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        aboutus = (Button)findViewById(R.id.buttonabtus);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutUs();
            }
        });

        profile1 = (Button) findViewById(R.id.buttonprofil);
        profile1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile();
            }
        });

        changepass = (Button) findViewById(R.id.buttontukarpass);
        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePass();
            }
        });

        contact= (Button) findViewById(R.id.buttonhubungi);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contact();
            }
        });

        location = (Button) findViewById(R.id.buttonlocation);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location();
            }
        });

        terms = (Button) findViewById(R.id.buttonsyarat);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TermsOfUse();
            }
        });

        //if letak button logout.
       logout = (Button)findViewById(R.id.buttonlogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });
    }

    private void AboutUs() {
        startActivity(new Intent(SettingActivity.this, AboutUsActivity.class));
    }

    private void profile(){
        startActivity(new Intent(SettingActivity.this, ProfileActivity.class));
    }
    private void updatePass(){
        startActivity(new Intent(SettingActivity.this, UpdatePassword.class));
    }

    private  void contact(){
        startActivity(new Intent(SettingActivity.this, ContactActivity.class));
    }

    private void location(){
        startActivity(new Intent(SettingActivity.this,LocationActivity.class));
    }

    private void TermsOfUse(){
        startActivity(new Intent(SettingActivity.this, TermsOfUseActivity.class));
    }

    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(SettingActivity.this, MainActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
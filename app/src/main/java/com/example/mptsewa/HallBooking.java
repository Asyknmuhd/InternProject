package com.example.mptsewa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class HallBooking extends AppCompatActivity {
    private TextView CID, COD, title;
    CalendarView calendarViewCID, calendarViewCOD;
    private Dialog popupCID, popupCOD;
    private Dialog popup;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Spinner spinner ;
    private ImageView image;
    private Switch kenduri, badminton, majlis;
    private TextView jamkenduri, jambadminton, jammajlis ;
    private FloatingActionButton confirm;
    ClassBooking classBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_booking);

        popupCID = new Dialog(this);
        popupCOD = new Dialog(this);
        CID = findViewById(R.id.tvCID);
        COD = findViewById(R.id.tvCOD);
        popup = new Dialog(this);
        spinner = findViewById(R.id.spinner);
        image = findViewById(R.id.image);
        kenduri = findViewById(R.id.switchkenduri);
        badminton = findViewById(R.id.switchbadminton);
        majlis = findViewById(R.id.switchmajlis);
        jamkenduri = findViewById(R.id.et_jamkenduri);
        jambadminton = findViewById(R.id.et_jambadminton);
        jammajlis = findViewById(R.id.et_jammajlis);
        confirm = findViewById(R.id.btnConfirm);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("ClassBooking");
        databaseReference = firebaseDatabase.getReference().child("ClassBooking");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        jamkenduri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(jamkenduri.getText().toString());
                classBooking.setJamkenduri(num);
            }
        });

        jambadminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(jambadminton.getText().toString());
                classBooking.setJambadminton(num);
            }
        });

        jammajlis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(jammajlis.getText().toString());
                classBooking.setJammajlis(num);
            }
        });

        //send to firebase
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                classBooking.setFromDate(CID.getText().toString());
                classBooking.setToDate(COD.getText().toString());
                if(classBooking.getJamkenduri() != 0 || classBooking.getJambadminton() != 0 || classBooking.getJammajlis() != 0 ){
                    databaseReference.child("booking1").setValue(classBooking);
                    Toast.makeText(HallBooking.this, "Sent to database", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(HallBooking.this, CheckoutActivity.class));
                } else {
                    Toast.makeText(HallBooking.this, "Please choose table", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //array
        String [] tempat = {"Pilih Lokasi Dewan","Dewan Bukit Bendera","Dewan Kuala Krau","Dewan Lanchang","Dewan Sri Bahagia",
                "Dewan Sri Mentakab","Dewan Sri Semantan","Dewan Sri Tualang","Dewan Taman Saga","Dewan Taman Temerloh Jaya","Dewan Tun Razak"};

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,tempat);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        image.setImageResource(R.drawable.dewanpilih);
                        break;
                    case 1:
                        image.setImageResource(R.drawable.dewanbukitbendera2);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.dewankualakrau);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.dewanlanchang);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.dewansribahagian);
                        break;
                    case 5:
                        image.setImageResource(R.drawable.dewansrimentakab);
                        break;
                    case 6:
                        image.setImageResource(R.drawable.dewansrisemantan);
                        break;
                    case 7:
                        image.setImageResource(R.drawable.dewansritualang);
                        break;
                    case 8:
                        image.setImageResource(R.drawable.dewantamansaga2);
                        break;
                    case 9:
                        image.setImageResource(R.drawable.dewantj2);
                        break;
                    case 10:
                        image.setImageResource(R.drawable.dewantunrazak);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //handle any errors
            }
        });

        kenduri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        badminton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
        majlis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

    }
    public void showPopupCID(View v){
        Button saveCID;

        popupCID.setContentView(R.layout.popup_fromdate);
        saveCID = popupCID.findViewById(R.id.saveCID);
        title = popupCID.findViewById(R.id.tvTitle1);
        calendarViewCID = popupCID.findViewById(R.id.calendarViewCID);

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popup_fromdate,(ViewGroup)findViewById(R.id.layoutCID));

        calendarViewCID.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dateCID = dayOfMonth + "/" + (month+1) + "/" + year;
                title.setText(dateCID);
                CID.setText(dateCID);
            }
        });

        saveCID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupCID.dismiss();
            }
        });
        popupCID.show();
    }

    public void showPopupCOD(View v){
        Button saveCOD;

        popupCOD.setContentView(R.layout.popup_todate);
        saveCOD = popupCOD.findViewById(R.id.saveCOD);
        title = popupCOD.findViewById(R.id.tvTitle2);
        calendarViewCOD = popupCOD.findViewById(R.id.calendarViewCOD);

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popup_todate, (ViewGroup)findViewById(R.id.layoutCOD));

        calendarViewCOD.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dateCOD = dayOfMonth + "/" + (month + 1) + "/" + year;
                title.setText(dateCOD);
                COD.setText(dateCOD);
            }
        });

        saveCOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupCOD.dismiss();
            }
        });
        popupCOD.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.SettingMenu:{
                startActivity(new Intent(HallBooking.this, SettingActivity.class));
                break;
            }
            case R.id.ProfileMenu: {
                startActivity(new Intent(HallBooking.this, ProfileActivity.class));
                break;
            }
            case android.R.id.home: {
                onBackPressed();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
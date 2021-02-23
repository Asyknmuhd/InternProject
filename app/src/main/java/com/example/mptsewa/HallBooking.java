package com.example.mptsewa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class HallBooking extends AppCompatActivity {
    private Spinner spinner ;
    private ImageView image;
    private Switch kenduri, badminton, majlis;
    private TextView totalsum;
    private int tiada = 0;
    private int sumkenduri = 2000;
    private int sumbadminton = 20;
    private int summajlis = 1800;
    private int sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_booking);

        spinner = findViewById(R.id.spinner);
        image = findViewById(R.id.image);

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

        kenduri = findViewById(R.id.switchkenduri);
        badminton = findViewById(R.id.switchbadminton);
        majlis = findViewById(R.id.switchmajlis);
        totalsum = findViewById(R.id.tvSum);

      //  kenduri.setChecked(new V);
        kenduri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Info.setText("Bilangan Percubaan: " + counter) ;(contoh)
                //sumbadminton = 20;
               // totalsum.setText("Jumlah:" + sumbadminton);
                if(isChecked == true){
                    totalsum.setText("Jumlah:" + sumkenduri);
                }else if (isChecked == false){
                    totalsum.setText("Jumlah:");
                }
                else if(kenduri.isChecked()==true && badminton.isChecked()==true){
                    sum = sumkenduri + sumbadminton ;
                    totalsum.setText("Jumlah"+sum);
                }
            }
        });
        badminton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Info.setText("Bilangan Percubaan: " + counter) ;(contoh)
                //sumbadminton = 20;
                // totalsum.setText("Jumlah:" + sumbadminton);
                if(isChecked == true){
                    totalsum.setText("Jumlah:" + sumbadminton);
                }else if (isChecked == false){
                    totalsum.setText("Jumlah:");
                }
            }
        });
        majlis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Info.setText("Bilangan Percubaan: " + counter) ;(contoh)
                //sumbadminton = 20;
                // totalsum.setText("Jumlah:" + sumbadminton);
                if(isChecked == true){
                    totalsum.setText("Jumlah:" + summajlis);
                }else if (isChecked == false){
                    totalsum.setText("Jumlah:");
                }
            }
        });


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
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
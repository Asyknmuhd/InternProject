package com.example.mptsewa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class HallBooking extends AppCompatActivity {
    private Spinner spinner ;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_booking);

        spinner = findViewById(R.id.spinner);
        image = findViewById(R.id.image);

        //array
        String [] tempat = {"Pilih satu","Dewan Bukit Bendera","Dewan Kuala Krau","Dewan Lanchang","Dewan Sri Bahagia","Dewan Sri Mentakab"
                            ,"Dewan Sri Semantan","Dewan Taman Saga","Dewan Taman Temerloh Jaya","Dewan Tun Razak"};

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,tempat);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
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
                        image.setImageResource(R.drawable.dewantj);
                        break;
                    case 10:
                        image.setImageResource(R.drawable.dewantunrazak);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
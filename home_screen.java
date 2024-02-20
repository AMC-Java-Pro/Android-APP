package com.example.amc_java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class home_screen extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap myMap;


    ImageView imgSearch;
    ImageView imgBook;
    SearchView mapSearch;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(home_screen.this);


        imgSearch = findViewById(R.id.idsearch1);
        imgBook = findViewById(R.id.imageView4);
        mapSearch = findViewById(R.id.Search);



        mapSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(home_screen.this, search_screen.class);
                startActivity(intent);

            }
        });
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(home_screen.this, search_screen.class);
                startActivity(intent);

            }
        });
        imgBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(home_screen.this, book_screen.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        myMap = googleMap;

        LatLng india = new LatLng(12.972442, 77.580643);
        googleMap.addMarker(new MarkerOptions().position(india).title("India"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(india));

    }
}

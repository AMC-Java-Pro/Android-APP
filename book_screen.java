package com.example.amc_java;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class book_screen extends AppCompatActivity {

    ImageView imgSearch;
    ImageView Home;
    Button pay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_screen);

        imgSearch = findViewById(R.id.idsearch1);
        Home = findViewById(R.id.imageView2);
        pay = findViewById(R.id.Pay);

        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(book_screen.this, search_screen.class);
                startActivity(intent);

            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(book_screen.this, home_screen.class);
                startActivity(intent);

            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                gotoUrl("https://amc-java-pro.github.io/PYMENT-WEB/");

            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
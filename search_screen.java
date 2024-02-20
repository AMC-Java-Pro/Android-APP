package com.example.amc_java;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class search_screen extends AppCompatActivity {

    ImageView imgBook;
    ImageView Home;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        Home = findViewById(R.id.imageView2);
        imgBook = findViewById(R.id.imageView4);


        imgBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(search_screen.this, book_screen.class);
                startActivity(intent);

            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(search_screen.this, home_screen.class);
                startActivity(intent);

            }
        });

    }

}
package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView affichage = (TextView) findViewById(R.id.TV1);
        affichage.setText("Application LeBonCoin");
        affichage.setTextSize(30);
        affichage.setGravity(Gravity.CENTER);
    }
}
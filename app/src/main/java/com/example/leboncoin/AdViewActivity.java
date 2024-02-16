package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AdViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        TextView affichage = (TextView) findViewById(R.id.textView);
        affichage.setText(Integer.toString(position));
    }
}
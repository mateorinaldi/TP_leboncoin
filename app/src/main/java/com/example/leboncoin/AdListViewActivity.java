package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);
        AdModel test1 = new AdModel("titre1", "adresse1", R.drawable.ic_launcher_background);
    }
}
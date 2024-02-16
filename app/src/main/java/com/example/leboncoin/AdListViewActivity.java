package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.text.TextRunShaper;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdModel test =  new AdModel("test","test",1);

        LinearLayout B= new LinearLayout(this);
        TextView e = new TextView(this);
        e.setText("Bonjour");
        B.addView(e);
        setContentView(B);
    }
}
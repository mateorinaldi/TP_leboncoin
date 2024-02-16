package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout C = new LinearLayout(this);
        TextView t = new TextView(this);
        t.setText("Adieu");
        C.addView(t);
        setContentView(C);
    }
}
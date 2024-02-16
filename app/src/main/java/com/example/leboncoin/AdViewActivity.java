package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AdViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout b = new LinearLayout(this);
        b.setOrientation(LinearLayout.VERTICAL);

        Intent i = getIntent();
        TextView title = new TextView(this);
        TextView address = new TextView(this);
        ImageView image = new ImageView(this);
        String t = i.getStringExtra("title");
        String a = i.getStringExtra("address");
        int im = i.getIntExtra("image",0);
        title.setText(t);
        address.setText(a);
        image.setImageResource(im);
        b.addView(title);
        b.addView(address);
        b.addView(image);
        //setContentView(R.layout.activity_ad_view);
        setContentView(b);


    }
}
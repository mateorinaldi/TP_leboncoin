package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.text.TextRunShaper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);
        AdModel test = new AdModel("test", "test", "crescentcity3",true);
        AdModel test2 = new AdModel("test2", "test2", "crescentcity3",true);
        ArrayList<AdModel> liste = new ArrayList<AdModel>();
        liste.add(test);
        liste.add(test2);
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String address = intent.getStringExtra("address");
            String imagePath = intent.getStringExtra("imagePath");
            AdModel ad = new AdModel(title,address,imagePath,false);
            liste.add(ad);

        }
        AdAdapter adapter = new AdAdapter(this, liste);
        ListView listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AdModel item = liste.get(position);

                    Intent ad_view = new Intent(AdListViewActivity.this, AdViewActivity.class);
                    ad_view.putExtra("title", item.getTitle());
                    ad_view.putExtra("address", item.getAddress());
                    ad_view.putExtra("image", item.getImage());
                    ad_view.putExtra("isDrawable",item.isDrawable);
                    startActivity(ad_view);

                }
            });

    }
}
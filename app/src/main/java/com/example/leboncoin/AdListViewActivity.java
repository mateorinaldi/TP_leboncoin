package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.text.TextRunShaper;
import android.os.Bundle;
import android.view.View;
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
        AdModel test =  new AdModel("test","test",R.drawable.ic_launcher_background);
        AdModel test2 =  new AdModel("test2","test2",R.drawable.crescentcity3);
        ArrayList<AdModel> liste = new ArrayList<AdModel>();
        liste.add(test);
        liste.add(test2);

        AdAdapter adapter = new AdAdapter(this,liste);
        ListView listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);

    }
}
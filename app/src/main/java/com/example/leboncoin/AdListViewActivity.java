package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.text.TextRunShaper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
        AdModel test1 =  new AdModel("test","test",R.drawable.ic_launcher_background);
        AdModel test2 =  new AdModel("test2","test2",R.drawable.crescentcity3);
        ArrayList<AdModel> liste = new ArrayList<AdModel>();
        liste.add(test1);
        liste.add(test2);

        AdAdapter adapter = new AdAdapter(this,liste);
        ListView listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);
        Context context = getApplicationContext();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AdModel item = adapter.getItemAtPosition(position);

                Intent intent = new Intent(context,AdViewActivity.class);
                intent.putExtra("position", position);
                //based on item add info to intent
                startActivity(intent);
            }
        });
    }
}
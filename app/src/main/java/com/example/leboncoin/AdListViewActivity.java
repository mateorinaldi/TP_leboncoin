package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.text.TextRunShaper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AdListViewActivity extends AppCompatActivity {
    private DBManager dbManager;
    private ListView listView;
    private DbAdAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);
        dbManager = DBManager.getDBManager(this);
        Button home = findViewById(R.id.button_home);
        home.setBackgroundColor(Color.WHITE);
        home.setText("Home");
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(AdListViewActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        //dbManager.init();

        dbManager.open();

        // Récupère les données depuis la base de données
        Cursor cursor = dbManager.fetch();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdAdapter adapter = new RecyclerViewAdAdapter(this, cursor);

        int numberOfColumns = 2;
        GridLayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Ferme la connexion à la base de données lorsque l'activité est détruite
        dbManager.close();
    }
}
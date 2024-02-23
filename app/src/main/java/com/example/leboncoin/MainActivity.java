package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button liste_annonces = findViewById(R.id.ad_list_button);
        Button ajouter_annonces = findViewById(R.id.ad_add_button);
        ImageView image_main = findViewById(R.id.image_accueil);
        TextView createurs = findViewById(R.id.texte_createurs);
        createurs.setText("Par Dorian Rousse, Matéo Rinaldi et Maxime Duval");


        image_main.setImageResource(R.drawable.image_accueil);
        liste_annonces.setText("Liste annonces");
        ajouter_annonces.setText("Ajouter une annonce");

        liste_annonces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent liste_ad = new Intent(MainActivity.this, AdListViewActivity.class);
                startActivity(liste_ad);
            }
        });
        ajouter_annonces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ajouter_ad = new Intent(MainActivity.this, AdAddActivity.class);
                startActivity(ajouter_ad);
            }
        });


    }

}
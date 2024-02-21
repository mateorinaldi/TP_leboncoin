package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LinearLayout A=new LinearLayout(this);
        Button liste_annonces=new Button(this);
        Button ajouter_annonces= new Button(this);

        A.setOrientation(LinearLayout.HORIZONTAL);
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
        A.addView(liste_annonces);
        A.addView(ajouter_annonces);

        setContentView(A);
    }
}

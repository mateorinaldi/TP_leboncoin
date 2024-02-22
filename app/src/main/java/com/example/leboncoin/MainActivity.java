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
        //LinearLayout A = new LinearLayout(this);
        setContentView(R.layout.activity_main);
        Button liste_annonces = findViewById(R.id.ad_list_button);
        Button ajouter_annonces = findViewById(R.id.ad_add_button);
        ImageView image_main = findViewById(R.id.image_accueil);
        TextView createurs = findViewById(R.id.texte_createurs);
        createurs.setText("Par Dorian Rousse, Matéo Rinaldi et Maxime Duval");


        image_main.setImageResource(R.drawable.image_accueil);
        //A.setOrientation(LinearLayout.HORIZONTAL);
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
        //A.addView(liste_annonces);
        //A.addView(ajouter_annonces);

        //SQLiteDatabase database = SQLiteDatabase.openDatabase("res/database/leboncoin.db", null, SQLiteDatabase.OPEN_READONLY);
        /*Cursor cursor = database.rawQuery("SELECT titre FROM articles WHERE titre='Iphone 7'", null);
        String donnees = cursor.getString(0);*/
        Resources res = getResources();
        String path = res.getString(R.string.db_path);
        //Context context = getApplicationContext();
        //String dbPath = context.getDatabasePath("nom_de_votre_base_de_donnees.db").getAbsolutePath();
        //SQLiteDatabase database = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READONLY);
        //Log.i("La valeur du title est",dbPath);

    }

}        /*
        LinearLayout b = new LinearLayout(this);
        b.setOrientation(LinearLayout.VERTICAL);


        ImageView imageView = new ImageView(this);

        // Chemin de l'image
        String imagePath = "drawable/crescentcity3/jpg";

        // Charger l'image dans l'ImageView
        loadImageFromPath(imagePath, imageView);
        int resourceId = getResources().getIdentifier("crescentcity3", "drawable", getPackageName());

// Charger l'image dans l'ImageView à partir des ressources drawable
        imageView.setImageResource(resourceId);

// Ajouter l'ImageView au LinearLayout
        b.addView(imageView);

// Définir le layout comme le contenu de l'activité


        setContentView(b);
    }

    private void loadImageFromPath(String path, ImageView imageView) {
        // Charger l'image depuis le chemin spécifié
        Bitmap bitmap = BitmapFactory.decodeFile(path);

        // Afficher l'image dans l'ImageView
        imageView.setImageBitmap(bitmap);
    }*/


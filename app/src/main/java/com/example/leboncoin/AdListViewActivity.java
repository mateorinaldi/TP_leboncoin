package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);
        AdModel test = new AdModel("test", "test", "crescentcity3",true,"1","1","1");
        AdModel test2 = new AdModel("test2", "test2", "crescentcity3",true,"1","1","1");
        ArrayList<AdModel> liste = new ArrayList<AdModel>();
        liste.add(test);
        liste.add(test2);
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String address = intent.getStringExtra("address");
            String imagePath = intent.getStringExtra("imagePath");
            String numero = intent.getStringExtra("numero_de_telephone");
            String description = intent.getStringExtra("description");
            String mail = intent.getStringExtra("mail");
            AdModel ad = new AdModel(title,address,imagePath,false,mail,numero,description);
            liste.add(ad);


        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdAdapter adapter = new RecyclerViewAdAdapter(this, liste);

        // Configurez le RecyclerView avec un GridLayoutManager à deux colonnes
        int numberOfColumns = 2;
        GridLayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        /*recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AdModel item = liste.get(position);

                    Intent ad_view = new Intent(AdListViewActivity.this, AdViewActivity.class);
                    ad_view.putExtra("title", item.getTitle());
                    ad_view.putExtra("address", item.getAddress());
                    ad_view.putExtra("mail", item.getMail());
                    ad_view.putExtra("numero_de_telephone", item.getNumero_de_telephone());
                    ad_view.putExtra("image", item.getImage());
                    ad_view.putExtra("isDrawable",item.isDrawable);
                    ad_view.putExtra("description",item.getDescription());
                    startActivity(ad_view);

                }
            });
*/
    }
}
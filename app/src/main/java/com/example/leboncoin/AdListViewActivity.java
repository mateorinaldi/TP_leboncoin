package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class AdListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);
        //AdModel test1 =  new AdModel("test","test",R.drawable.ic_launcher_background);
        //AdModel test2 =  new AdModel("test2","test2",R.drawable.crescentcity3);
        //ArrayList<AdModel> liste = new ArrayList<AdModel>();
        //liste.add(test1);
        //liste.add(test2);
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String address = intent.getStringExtra("address");
            String imagePath = intent.getStringExtra("imagePath");
            String numero_de_telephone = intent.getStringExtra("numero_de_telephone"); //problème car les numéros de la base de données sont en int
            String description = intent.getStringExtra("description");
            String mail = intent.getStringExtra("mail");
            String price = intent.getStringExtra("price");
            String seller = intent.getStringExtra("seller");
            String category = intent.getStringExtra("category");

            DbAdModel ad = new DbAdModel(longeur_base_de_donnee+1,imagePath,false, title,description, Integer.parseInt(price), category, seller, address, numero_de_telephone,mail,true);
            liste.add(ad); // comment ajouter un item dans la base de donnée?

        }

        DBManager dbManager = DBManager.getDBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        DbAdAdapter adapter = new DbAdAdapter(this, cursor, R.layout.item_listview_ad);
        ListView listview = findViewById(R.id.listview);
        listview.setAdapter(adapter);

        String list_annonces = String.valueOf(listview);
        Log.i("list_annonces", list_annonces);

        Context context = getApplicationContext();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(context,AdViewActivity.class);
                intent.putExtra("position", position);          //comment accéder aux items de la base de données
                //based on item add info to intent
                intent.putExtra("title", item.getTitle());
                intent.putExtra("address", item.getAddress());
                intent.putExtra("mail", item.getMail());
                intent.putExtra("numero_de_telephone", item.getTelephone());
                intent.putExtra("image", item.getImage());
                intent.putExtra("isDrawable",item.isDrawable);
                intent.putExtra("description",item.getDescription());
                intent.putExtra("category",item.getCategory());
                intent.putExtra("seller",item.getSeller());
                startActivity(intent);
            }
        });
    }
}
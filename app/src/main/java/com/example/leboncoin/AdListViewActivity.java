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
                intent.putExtra("position", position);
                //based on item add info to intent
                startActivity(intent);
            }
        });
    }
}
package com.example.leboncoin;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdListViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super. onCreate(savedInstanceState ); setContentView(R.layout.activity_listview_ad );
        AdModel ad1 = new AdModel("Short", "38 rue des clos", R.drawable.ic_launcher_background) ;
        AdModel ad2 = new AdModel("Plante", "58 rue de la ruche", R.drawable.ic_launcher_background) ;
        AdModel ad3 = new AdModel("Table", "98 rue des roches", R.drawable.ic_launcher_background) ;
        AdModel ad4 = new AdModel("Cuisine", "48 rue des forges", R.drawable.ic_launcher_background) ;
        ArrayList<AdModel> Liste_model = new ArrayList<>();
        Liste_model.add(ad1);
        Liste_model.add(ad2);
        Liste_model.add(ad3);
        Liste_model.add(ad4);

        ListView L1 = (ListView) findViewById(R.id.List_1);
        AdAdapter adA = new AdAdapter(this, Liste_model);
        L1.setAdapter(adA);
    }
}

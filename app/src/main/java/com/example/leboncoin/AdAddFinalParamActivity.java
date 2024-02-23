package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdAddFinalParamActivity extends AppCompatActivity {
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_add_final_param);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String imagePath = intent.getStringExtra("imagePath");
        String adresse = intent.getStringExtra("address");
        String mail = intent.getStringExtra("mail");
        String numero = intent.getStringExtra("numero");
        String name = intent.getStringExtra("name");

        EditText cat = findViewById(R.id.param_category);
        EditText desc = findViewById(R.id.param_description);
        EditText pr = findViewById(R.id.param_price);
        Button valider = findViewById(R.id.ajouter_annonce_finale);
        cat.setText("Categorie");
        desc.setText("Description");
        pr.setText("Prix");
        String adPrice = pr.getText().toString();
        String adDesc = desc.getText().toString();
        String category = cat.getText().toString();
        Log.d("donnéessssssss",title);
        Log.d("donnéessssssss",adresse);
        Log.d("donnéessssssss",imagePath);
        Log.d("donnéessssssss",mail);
        Log.d("donnéessssssss",numero);
        Log.d("donnéessssssss",name);
        Log.d("donnéessssssss",adDesc);
        Log.d("donnéessssssss",adPrice);
        Log.d("donnéessssssss",category);
        dbManager = DBManager.getDBManager(this);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adPrice = pr.getText().toString();
                String adDesc = desc.getText().toString();
                String category = cat.getText().toString();
                int num = Integer.parseInt(numero);

                int price = Integer.parseInt(adPrice);

                DbAdModel ad = new DbAdModel(0, imagePath, title, adDesc, price, category, name, adresse, num, mail, "False");

                dbManager.open();
                dbManager.insert(ad);
                dbManager.close();
                Intent im = new Intent(AdAddFinalParamActivity.this, AdListViewActivity.class);
                im.putExtra("title", title);
                im.putExtra("address", adresse);
                // Passez le chemin de l'image
                im.putExtra("imagePath", imagePath);
                startActivity(im);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Ferme la connexion à la base de données lorsque l'activité est détruite
        dbManager.close();
    }

}
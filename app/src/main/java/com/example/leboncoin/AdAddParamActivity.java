package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdAddParamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_add_param);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String imagePath = intent.getStringExtra("imagePath");
        String adresse = intent.getStringExtra("address");

        EditText name = findViewById(R.id.nom_vendeur);
        EditText numero = findViewById(R.id.numero_ad_add);
        EditText mail = findViewById(R.id.mail_vendeur);
        Button next = findViewById(R.id.suivant_infos_vendeur);
        numero.setText("Numero");
        name.setText("Nom du vendeur/fournisseur");
        mail.setText("adresse mail");
        next.setText("Suivant");


        String adName = name.getText().toString();
        String adnumero = numero.getText().toString();
        String admail = mail.getText().toString();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdAddParamActivity.this, AdAddFinalParamActivity.class);
                i.putExtra("title",title);
                i.putExtra("address",adresse);
                i.putExtra("imagePath",imagePath);
                i.putExtra("mail",admail);
                i.putExtra("numero",adnumero);
                i.putExtra("name",adName);
                startActivity(i);
            }
        });
    }
}
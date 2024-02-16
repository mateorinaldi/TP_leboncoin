package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setText("Envoyer vers page 1");
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setText("Envoyer vers page 2");
        //final EditText e = (EditText) findViewById(R.id. );
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lancementSecondeActivite = new Intent(MainActivity.this, AdAddActivity.class);
                //lancementSecondeActivite.putExtra("message", e.getText(). toString ());
                startActivity(lancementSecondeActivite);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lancementtroisiemeActivite = new Intent(MainActivity.this, AdListViewActivity.class);
                //lancementSecondeActivite.putExtra("message", e.getText(). toString ());
                startActivity(lancementtroisiemeActivite);
            }
        });
    }
}
package com.example.leboncoin;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.URLEncoder;

public class AdViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState ); setContentView(R.layout.activity_view_activity );
        TextView text1 = (TextView) findViewById(R.id.TextView_ac_view_1);
        TextView text2 = (TextView) findViewById(R.id.TextView_ac_view_2);
        ImageView img1 = (ImageView) findViewById(R.id.ImageView_ac_view);

        Intent intent = getIntent();
        String  address = intent.getStringExtra("address");
        String title = intent.getStringExtra("title");
        int image = intent.getIntExtra("image", 0);

        img1.setImageResource(image);
        text1.setText(title);
        text2.setText(address);

        FloatingActionButton b3 = (FloatingActionButton) findViewById(R.id.Button_map_view_activity);
        FloatingActionButton b4 = (FloatingActionButton) findViewById(R.id.Button_phone_view_activity);
        FloatingActionButton b5 = (FloatingActionButton) findViewById(R.id.Button_mail_view_activity);


        String transfromaddress = transformAddress(address);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override//
            public void onClick(View view) {
                // Map point based on address
                Uri location = Uri.parse(transfromaddress);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                startActivity(mapIntent);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "+33 06 17 28 59 59";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(android.content.Intent.EXTRA_EMAIL,"email@gmail.com");
                email.putExtra(Intent.EXTRA_SUBJECT, "LebonCoin");
                email.putExtra(Intent.EXTRA_TEXT, "Cet objet est-il toujours disponible");
                email.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(email, "Choisir le logiciel"));
            }
        });
    }

    private String transformAddress(String address) {
        String encodedAddress = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            encodedAddress = URLEncoder.encode(address.replace(" ", " "), java.nio.charset.StandardCharsets.UTF_8);
        }
        String transformedAddress = "geo:0,0?q=" + encodedAddress;
        return transformedAddress;
    }
}
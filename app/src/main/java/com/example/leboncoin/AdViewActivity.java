package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.net.URLEncoder;

public class AdViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view);
        //LinearLayout b = new LinearLayout(this);
        //b.setOrientation(LinearLayout.VERTICAL);


        Intent i = getIntent();
        boolean isdraw = i.getBooleanExtra("isDrawable",false);
        TextView title = findViewById(R.id.title_adview);
        TextView address = findViewById(R.id.address_adview);
        TextView description = findViewById(R.id.description);
        ImageView image = findViewById(R.id.image_adview);
        FloatingActionButton b3 = (FloatingActionButton) findViewById(R.id.Button_map_view_activity);
        FloatingActionButton b4 = (FloatingActionButton) findViewById(R.id.Button_phone_view_activity);
        FloatingActionButton b5 = (FloatingActionButton) findViewById(R.id.Button_mail_view_activity);

        String t = i.getStringExtra("title");
        String a = i.getStringExtra("address");
        String imagePath = i.getStringExtra("image");
        String desc = i.getStringExtra("description");
        String mail = i.getStringExtra("mail");
        String numero = i.getStringExtra("numero_de_telephone");

        if (isdraw == true) {
            int im = this.getResources().getIdentifier(imagePath,"drawable",this.getPackageName());
            image.setImageResource(im);
        }
        else {
            Bitmap bmp = BitmapFactory.decodeFile(imagePath);
            image.setImageBitmap(bmp);
        }

        title.setText(t);
        address.setText(a);
        description.setText(desc);

        /*b.addView(title);
        b.addView(address);
        b.addView(image);*/
        //setContentView(R.layout.activity_ad_view);

        String transfromaddress = transformAddress(a);
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
                String phone = numero;
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{mail});
                email.putExtra(Intent.EXTRA_SUBJECT, "LebonCoin");
                email.putExtra(Intent.EXTRA_TEXT, "Cet objet est-il toujours disponible?");
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
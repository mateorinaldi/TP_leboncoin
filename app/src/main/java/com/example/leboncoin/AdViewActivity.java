package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        ImageView image = findViewById(R.id.image_adview);
        String t = i.getStringExtra("title");
        String a = i.getStringExtra("address");
        String imagePath = i.getStringExtra("image");
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

        /*b.addView(title);
        b.addView(address);
        b.addView(image);*/
        //setContentView(R.layout.activity_ad_view);



    }
}
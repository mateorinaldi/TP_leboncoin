package com.example.leboncoin;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdAddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super. onCreate(savedInstanceState ); setContentView(R.layout.activity_add_ad );

        TextView Text1 = (TextView) findViewById(R.id.editTitle_add_ad);
        TextView Text2 = (TextView) findViewById(R.id.editAddress_add_ad);
        ImageView Img1 = (ImageView) findViewById(R.id.imageView_add_ad);

        int img = R.drawable.ic_launcher_background;
        String text1 = Text1.getText().toString();
        String text2 = Text2.getText().toString();

        Button b = (Button) findViewById(R.id.ButtonSend_add_ad);
        Context context = this.getApplicationContext();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addActivity = new Intent( context, AdViewActivity.class);
                addActivity.putExtra("address", text2);
                addActivity.putExtra("image", img);
                addActivity.putExtra("title", text1);
            }
        });
    }
}
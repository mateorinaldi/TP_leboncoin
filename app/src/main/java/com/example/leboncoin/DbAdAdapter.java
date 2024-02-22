package com.example.leboncoin;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DbAdAdapter extends CursorAdapter {
    private final int item_layout;

    public DbAdAdapter(Context context, Cursor c, int layout) {
        super(context, c);
        item_layout = layout;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(item_layout, viewGroup, false);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView titleTextView = (TextView) view.findViewById(R.id.title_ad);
        TextView addressTextView = (TextView) view.findViewById(R.id.adress_ad);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_ad);
        String title = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.TITLE));
        String address = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.ADDRESS));
        String image = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.IMAGE));

        //Bitmap bmp = BitmapFactory.decodeFile(image);
        int im = context.getResources().getIdentifier(image,"drawable",context.getPackageName());
        titleTextView.setText(title);
        addressTextView.setText("Adresse : " + address);
        if (im==0) {
            Bitmap bmp = BitmapFactory.decodeFile(image);
            imageView.setImageBitmap(bmp);
        }
        else {
            //imageView.setImageBitmap(bmp);
            imageView.setImageResource(im);
        }
        Log.d("qjknjqrgvnkqjvnjqbn", String.valueOf(im));
    }
}
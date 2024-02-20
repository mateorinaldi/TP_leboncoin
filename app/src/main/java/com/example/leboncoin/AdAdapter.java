package com.example.leboncoin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Objects;

public class AdAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<AdModel> adModelArrayList;
    private final LayoutInflater inflater;

    public AdAdapter(Context context, ArrayList<AdModel> adModelArrayList) {
        this.context = context;
        this.adModelArrayList = adModelArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return adModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return adModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AdModel ad = adModelArrayList.get(i);
        view = inflater.inflate(R.layout.item_listview_ad, null);

        ImageView imageTV = view.findViewById(R.id.image_ad);
        TextView titleTV = view.findViewById(R.id.title_ad);
        TextView addressTV = view.findViewById(R.id.adress_ad);

        // Si l'image est une ressource drawable
        if (ad.isDrawable) {
            int resId = context.getResources().getIdentifier(ad.getImage(), "drawable", context.getPackageName());
            if (resId != 0) {
                imageTV.setImageResource(resId);
                Log.d("image drawable",ad.getImage());
            }
        } else { // Si l'image provient de la galerie
            String imagePath = ad.getImage();

            if (imagePath != null && !imagePath.isEmpty()) {
                Log.d("image non drawable",imagePath);
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                if (bitmap != null) {
                    imageTV.setImageBitmap(bitmap);
                }
            }
        }

        titleTV.setText(ad.getTitle());
        addressTV.setText(ad.getAddress());

        return view;
    }
}


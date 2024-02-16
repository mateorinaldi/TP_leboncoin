package com.example.leboncoin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdAdapter {

    private final Context context;
    private final ArrayList<AdModel> adModelArrayList;
    private final LayoutInflater inflater;

    // Constructor
    public AdAdapter(Context context, ArrayList<AdModel> adModelArrayList) {
        this.context = context;
        this.adModelArrayList = adModelArrayList;
        inflater = (LayoutInflater.from(context));
    }

    public int getCount() {
        return adModelArrayList.size();
    } // Return ad number


    public Object getItem(int i) {
        return adModelArrayList.get(i);
    } // Return ad number i


    public long getItemId(int i) {
        return i;
    } // Return ad id i


    public View getView(int i, View view, ViewGroup viewGroup) {
        // Get ad number iAdModel ad = ... ;
        AdModel ad = adModelArrayList.get(i);
        view = inflater.inflate(R.layout.item_listview_ad, null);
        // Get the image view and both text views
        ImageView imageIV = view.findViewById(R.id.IV1);
        TextView titleTV = view.findViewById(R.id.TV3);
        TextView addressTV = view.findViewById(R.id.TV4);

        imageIV.setImageResource(ad.getImage());
        titleTV.setText(ad.getTitle());
        addressTV.setText(ad.getAddress());
        return view;
    }
}

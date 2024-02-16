package com.example.leboncoin;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AdAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<AdModel> adModelArrayList;
    private final LayoutInflater inflater;
    // Constructor
    public AdAdapter(Context context, ArrayList<AdModel> adModelArrayList) {
        this.context = context;
        this.adModelArrayList = adModelArrayList;
        inflater = (LayoutInflater.from(context));
    } @Override
    public int getCount() { return adModelArrayList.toArray().length;} // Return ad number
    @Override
    public Object getItem(int i) { return adModelArrayList.get(i); } // Return ad number i
    @Override
    public long getItemId(int i) { return i; } // Return ad id i
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Get ad number i
        AdModel ad = adModelArrayList.get(i);
        view = inflater.inflate(R.layout.item_listview_ad, null);
// Get the image view and both text views
        ImageView imageIV = view.findViewById(R.id.image_modele);
        TextView titleTV = view.findViewById(R.id.text_modele_1);
        TextView addressTV = view.findViewById(R.id.text_modele_2);
        imageIV.setImageResource(ad.getImage());
        titleTV.setText(ad.getTitle());
        addressTV.setText(ad.getAddress());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ViewActivity = new Intent( context, AdViewActivity.class);
                ViewActivity.putExtra("message", e.getText(). toString ());
                context.startActivity(ViewActivity);
            }
        });

        return view;
    }
}

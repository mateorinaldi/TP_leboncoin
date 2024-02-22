package com.example.leboncoin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdAdapter extends RecyclerView.Adapter<RecyclerViewAdAdapter.RecyclerViewHolder> {
    private List<AdModel> adModelArrayList;
    private Context context;

    public RecyclerViewAdAdapter(Context context, List<AdModel> data) {
        this.context = context;
        this.adModelArrayList = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_ad, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        AdModel ad = adModelArrayList.get(position);
        holder.titleTextView.setText(ad.getTitle());
        holder.addressTextView.setText(ad.getAddress());

        // Vérifiez si l'image est une ressource drawable
        if (ad.isDrawable) {
            int resId = context.getResources().getIdentifier(ad.getImage(), "drawable", context.getPackageName());
            if (resId != 0) {
                holder.imageView.setImageResource(resId);
                Log.d("image drawable",ad.getImage());
            }
        } else { // Si l'image provient de la galerie
            String imagePath = ad.getImage();

            if (imagePath != null && !imagePath.isEmpty()) {
                Log.d("image non drawable",imagePath);
                Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
                if (bitmap != null) {
                    holder.imageView.setImageBitmap(bitmap);
                }
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ViewActivity = new Intent(context, AdViewActivity.class);
                ViewActivity.putExtra("address", ad.getAddress());
                ViewActivity.putExtra("image", ad.getImage());
                ViewActivity.putExtra("title", ad.getTitle());
                ViewActivity.putExtra("mail", ad.getMail());
                ViewActivity.putExtra("numero_de_telephone", ad.getNumero_de_telephone());
                ViewActivity.putExtra("isDrawable", ad.isDrawable);
                ViewActivity.putExtra("description", ad.getDescription());

                context.startActivity(ViewActivity);
            }
        });
    }


    @Override
    public int getItemCount() {
        return adModelArrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;
        public final TextView titleTextView;
        public final TextView addressTextView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_ad);
            titleTextView = itemView.findViewById(R.id.title_ad);
            addressTextView = itemView.findViewById(R.id.adress_ad);
        }
    }
}

package com.example.leboncoin;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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
    private Cursor cursor;
    private Context context;

    public RecyclerViewAdAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_ad, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if (!cursor.moveToPosition(position)) {
            return;
        }

        String title = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.TITLE));
        String address = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.ADDRESS));
        String image = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.IMAGE));
        String description = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.DESCRIPTION));

        holder.titleTextView.setText(title);
        holder.addressTextView.setText(address);

        // Vérifiez si l'image est une ressource drawable
        int resId = context.getResources().getIdentifier(image, "drawable", context.getPackageName());
        if (resId != 0) {
            holder.imageView.setImageResource(resId);
            Log.d("image drawable", image);
        } else { // Si l'image provient de la galerie
            Bitmap bitmap = BitmapFactory.decodeFile(image);
            if (bitmap != null) {
                holder.imageView.setImageBitmap(bitmap);
            }
        }

        // Gestion de l'événement de clic sur l'élément de la liste
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ViewActivity = new Intent(context, AdViewActivity.class);
                ViewActivity.putExtra("address", address);
                ViewActivity.putExtra("image", image);
                ViewActivity.putExtra("title", title);
                ViewActivity.putExtra("description",description);

                // Vous pouvez ajouter d'autres données à transmettre à l'activité de détails ici

                context.startActivity(ViewActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
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

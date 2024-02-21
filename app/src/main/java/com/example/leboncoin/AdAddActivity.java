package com.example.leboncoin;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdAddActivity extends AppCompatActivity {

    ImageView click_image;
    Button camera_open_id;
    Button gallery_open_id;
    String imagePath = "";

    ActivityResultLauncher<Intent> cameraActivityResultLauncher;
    ActivityResultLauncher<Intent> galleryActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_add);

        EditText title = findViewById(R.id.Edit_Text_title);
        EditText address = findViewById(R.id.Edit_text_address);
        click_image = findViewById(R.id.image_add_annonce);
        camera_open_id = findViewById(R.id.button_camera);
        gallery_open_id = findViewById(R.id.button_galerie);

        title.setText("Nom");
        address.setText("Adresse");
        camera_open_id.setText("Ouvrir caméra");
        gallery_open_id.setText("Ouvrir galerie");


        cameraActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null && data.getExtras() != null) {
                        // Récupérer l'image bitmap
                        Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
                        click_image.setImageBitmap(imageBitmap);

                        // Convertir le Bitmap en chemin de fichier
                        imagePath = saveBitmap(imageBitmap); // Mettre à jour la variable de niveau de classe
                        address.setText(imagePath);
                    }
                }
            }
        });

        galleryActivityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null && data.getData() != null) {
                        Uri imageUri = data.getData();
                        click_image.setImageURI(imageUri);

                        // Récupérer le chemin de l'image à partir de l'URI
                        imagePath = getPathFromUri(imageUri); // Mettre à jour la variable de niveau de classe
                        title.setText(imagePath);

                    }
                }
            }
        });

        camera_open_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraActivityResultLauncher.launch(camera);
            }
        });

        gallery_open_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                galleryActivityResultLauncher.launch(gallery);
            }
        });

        Button send = findViewById(R.id.button_ajouter_annonce);
        send.setText("Valider");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adTitle = title.getText().toString();
                String adAddress = address.getText().toString();
                Intent intent = new Intent(AdAddActivity.this, AdListViewActivity.class);
                intent.putExtra("title", adTitle);
                intent.putExtra("address", adAddress);

                // Passez le chemin de l'image
                intent.putExtra("imagePath", imagePath);

                File imgFile = new File(imagePath);
               /* if (imgFile.exists()) {
                    // Le fichier existe
                    Log.d("image existe", imagePath);
                } else {
                    // Le fichier n'existe pas
                    Log.d("pas d'images",imagePath);
                }*/
                startActivity(intent);
            }
        });
    }

    private String getPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String imagePath = cursor.getString(columnIndex);
            cursor.close();
            return imagePath;
        }
        return null;
    }

    private String saveBitmap(Bitmap bitmap) {
        File directory = getExternalFilesDir(null);
        File file = new File(directory, "image.jpg");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            return file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

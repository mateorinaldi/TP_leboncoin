package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.text.TextRunShaper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AdListViewActivity extends AppCompatActivity {
    private DBManager dbManager;
    private ListView listView;
    private DbAdAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);
        /*AdModel ad1 = new AdModel("Raspberry pi 0W", "8 Rue Colbrant, 59000 Lille", "i1", true, "mathiasribeiro62@free.fr", "+33 06 45 78 49 22", "Carte Raspberry pi neuve, jamais utilisée, datant de 2020");
        AdModel ad2 = new AdModel("Aspirateur sans fil Dyson", "75 Rue du 14 Juillet, 59113 Seclin", "i2", true, "lopez.jeanne478@gmail.com", "+33 06 11 22 44 57", "Aspirateur utilisé 1 an, très bon état, modèle : v15s detect submarine");
        AdModel ad3 = new AdModel("Huawei P30", "26 Rue Napoléon Demarquette, 62110 Hénin-Beaumont", "i3", true, "arnaud59.tysiere@orange.fr", null, "Téléphone huawei, utilisé 1 an, arrière légèrement abîmé");
        AdModel ad4 = new AdModel("Renault clio 3", "263 Rue du Grand Bail, 59500 Douai", "i4", true, "sylvie.adou@hotmail.fr", null, "Renault Clio 3 en très bon état, CT fait, 180000km, prix : 4500€ non négociable");
        AdModel ad5 = new AdModel("Iphone 7", "12 Rue Gustave Deloeil, 59119 Waziers", "i5", true, "simonin.julien@gmail.com", "+33 07 52 46 88 79", "Iphone 7 128Go, bon état, prix négociable");
        AdModel ad6 = new AdModel("Ordinateur Dell precision T1500", "12 Rue des Capucins, 62000 Arras", "i6", true, "christelle.trouf@gmail.com", "+33 07 45 13 26 88", "Ordinateur Dell, processeur i5, 8Go de RAM, SSD 256Go");
        AdModel ad7 = new AdModel("Samsung galaxy S20", "286 Cité du Bois d'Epinoy, 62820 Libercourt", "i7", true, "adam.souffier@orange.fr", "+33 03 57 46 82 91", "Ecran cassé en haut, prévoir réparation");
        AdModel ad8 = new AdModel("Citroën C3", "28 Rue Fernand Pantigny, 62590 Oignies", "i8", true, "saphira.selim7@gmail.com", "+33 03 83 46 79 58", "Pare-choc légèrement rayé, 160000km, prix non négociable");
        AdModel ad9 = new AdModel("T-shirt neuf", "19 Rue de Douai, 59151 Arleux", "i9", true, "clementdalinoux@proton.me", "+33 06 46 59 31 32", "T-shirt H&M jamais mis, ticket de caisse dispo");
        AdModel ad10 = new AdModel("Lave-vaisselle Bosch", "4 Rue Jean Baptiste Charcot, 62000 Dainville", "i10", true, "hochiere.pauline@gmail.com", "+33 01 24 52 15 47", "Lave-vaisselle en bon état, pas de problème technique, légers accros sur la porte, modèle SMS4ETI28E");
        AdModel ad11 = new AdModel("Blender haute vitesse moulinex", "14 Rue Emile Combes, 62800 Liévin", "i11", true, "lucie.salui@gmail.com", "+33 06 42 15 24 43", "Blender modèle PERFECTMIX COOK 1400 W SILVER");
        AdModel ad12 = new AdModel("Tente Forclaz 2 places", "29 Rue de Cambrai, 59169 Cantin", "i12", true, "bachelot.remi@gmail.com", "+33 07 24 51 62 43", "Tente 2 places, prix non négociable, achetée 250€");
        AdModel ad13 = new AdModel("Pull avec capuche Kiabi", "5 Rue du Kiosque, 59500 Douai", "i13", true, "jean-marc.bolard@gmail.com", "+33 06 43 89 53 15", "Pull rouge jamais porté, taille L");
        AdModel ad14 = new AdModel("Pantalon porté 1 an", "34 Rue Pierre Brossolette, 59450 Sin-le-Noble", "i14", true, "epiro.philippe@hotmail.fr", "+33 01 25 84 16 28", "Pantalon de marque Kaporal, porté 1 an, trop petit pour moi, taille 42, vendu 25€");
        AdModel ad15 = new AdModel("Airmax", "10 Rue de la Liberté, 62119 Dourges", "i15", true, "emeline.frunge@free.fr", "+33 09 64 31 52 11", "Modèle : Air Max 1 Keep Rippin Stop Slippin");
        AdModel ad16 = new AdModel("MacBook Pro 13 pouces", "4 Rue Jean Baptiste Charcot, 62000 Dainville", "i16", true, "hochiere.pauline@gmail.com", "+33 01 24 52 15 47", "MacBook Pro en excellent état, modèle 2019, SSD 512Go, RAM 8Go");
        AdModel ad17 = new AdModel("Playstation 5", "26 Rue Napoléon Demarquette, 62110 Hénin-Beaumont", "i17", true, "arnaud59.tysiere@orange.fr", null, "Console PS5 neuve sous blister, garantie constructeur, jamais ouverte");
        AdModel ad18 = new AdModel("Vélo de route Giant", "29 Rue de Cambrai, 59169 Cantin", "i18", true, "bachelot.remi@gmail.com", "+33 07 24 51 62 43", "Vélo de course Giant, cadre carbone, équipement Shimano Ultegra, taille M");
        AdModel ad19 = new AdModel("Table basse en bois massif", "12 Rue Gustave Deloeil, 59119 Waziers", "i19", true, "simonin.julien@gmail.com", "+33 07 52 46 88 79", "Table basse artisanale en chêne, style moderne, état impeccable");
        AdModel ad20 = new AdModel("Sac à dos North Face", "5 Rue du Kiosque, 59500 Douai", "i20", true, "jean-marc.bolard@gmail.com", "+33 06 43 89 53 15", "Sac à dos TNF, modèle Recon, parfait état, idéal pour la randonnée");
        AdModel ad21 = new AdModel("Montre connectée Apple Watch", "286 Cité du Bois d'Epinoy, 62820 Libercourt", "i21", true, "adam.souffier@orange.fr", "+33 03 57 46 82 91", "Apple Watch Series 6, GPS + Cellular, boîtier aluminium, bracelet sport");
        AdModel ad22 = new AdModel("Chaussures de running Nike", "12 Rue Gustave Deloeil, 59119 Waziers", "i22", true, "simonin.julien@gmail.com", "+33 07 52 46 88 79", "Chaussures de course Nike Air Zoom Pegasus, pointure 42, état neuf");
        AdModel ad23 = new AdModel("Canapé d'angle convertible", "12 Rue des Capucins, 62000 Arras", "i23", true, "christelle.trouf@gmail.com", "+33 07 45 13 26 88", "Canapé d'angle en tissu, convertible, couleur gris clair, très confortable");
        AdModel ad24 = new AdModel("Appareil photo Canon EOS", "28 Rue Fernand Pantigny, 62590 Oignies", "i24", true, "saphira.selim7@gmail.com", "+33 03 83 46 79 58", "Canon EOS 80D, objectif 18-135mm, excellent état, peu utilisé");
        AdModel ad25 = new AdModel("Enceinte Bluetooth JBL", "75 Rue du 14 Juillet, 59113 Seclin", "i25", true, "lopez.jeanne478@gmail.com", "+33 06 11 22 44 57", "Enceinte JBL Charge 4, waterproof, autonomie longue durée, comme neuve");
        AdModel ad26 = new AdModel("Skateboard électrique", "8 Rue Colbrant, 59000 Lille", "i26", true, "mathiasribeiro62@free.fr", "+33 06 45 78 49 22", "Skateboard électrique Boosted Mini X, autonomie 22 km, vitesse max 32 km/h");
        AdModel ad27 = new AdModel("Guitare électrique Fender", "29 Rue de Cambrai, 59169 Cantin", "i27", true, "bachelot.remi@gmail.com", "+33 07 24 51 62 43", "Guitare Fender Stratocaster American Professional, sunburst, état impeccable");
        AdModel ad28 = new AdModel("Imprimante multifonction HP", "19 Rue de Douai, 59151 Arleux", "i28", true, "clementdalinoux@proton.me", "+33 06 46 59 31 32", "Imprimante HP OfficeJet Pro 9025, wifi, fax, scanner, comme neuve");
        AdModel ad29 = new AdModel("Barbecue Weber", "26 Rue Napoléon Demarquette, 62110 Hénin-Beaumont", "i29", true, "arnaud59.tysiere@orange.fr", null, "Barbecue à gaz Weber Spirit II E-310, utilisé seulement quelques fois, comme neuf");
        AdModel ad30 = new AdModel("Chaise de bureau ergonomique", "10 Rue de la Liberté, 62119 Dourges", "i30", true, "emeline.frunge@free.fr", "+33 09 64 31 52 11", "Chaise de bureau IKEA Markus, réglable en hauteur, excellent soutien lombaire");
        AdModel ad31 = new AdModel("Sac à main Louis Vuitton", "34 Rue Pierre Brossolette, 59450 Sin-le-Noble", "i31", true, "epiro.philippe@hotmail.fr", "+33 01 25 84 16 28", "Sac à main Louis Vuitton Speedy Bandoulière 30, modèle classique, authentique");
        AdModel ad32 = new AdModel("Drone DJI Mavic Air 2", "14 Rue Emile Combes, 62800 Liévin", "i32", true, "lucie.salui@gmail.com", "+33 06 42 15 24 43", "Drone DJI Mavic Air 2 Fly More Combo, utilisé une seule fois, état parfait");
        AdModel ad33 = new AdModel("Veste en cuir véritable", "263 Rue du Grand Bail, 59500 Douai", "i33", false, "sylvie.adou@hotmail.fr", "+33 06 75 48 19 23", "Veste en cuir véritable, taille M, style vintage, excellente qualité");
        AdModel ad34 = new AdModel("Téléviseur Samsung 55 pouces", "4 Rue Jean Baptiste Charcot, 62000 Dainville", "i34", false, "hochiere.pauline@gmail.com", "+33 12 45 21 54 7", "TV Samsung 4K UHD Smart TV, modèle Crystal UHD TU8000, comme neuf");


        ArrayList<AdModel> liste = new ArrayList<AdModel>();
        liste.add(ad1);
        liste.add(ad2);
        liste.add(ad3);
        liste.add(ad4);
        liste.add(ad5);
        liste.add(ad6);
        liste.add(ad7);
        liste.add(ad8);
        liste.add(ad9);
        liste.add(ad10);
        liste.add(ad11);
        liste.add(ad12);
        liste.add(ad13);
        liste.add(ad14);
        liste.add(ad15);
        liste.add(ad16);
        liste.add(ad17);
        liste.add(ad18);
        liste.add(ad19);
        liste.add(ad20);
        liste.add(ad21);
        liste.add(ad22);
        liste.add(ad23);
        liste.add(ad24);
        liste.add(ad25);
        liste.add(ad26);
        liste.add(ad27);
        liste.add(ad28);
        liste.add(ad29);
        liste.add(ad30);
        liste.add(ad31);
        liste.add(ad32);
        liste.add(ad33);
        liste.add(ad34);
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String address = intent.getStringExtra("address");
            String imagePath = intent.getStringExtra("imagePath");
            String numero = intent.getStringExtra("numero_de_telephone");
            String description = intent.getStringExtra("description");
            String mail = intent.getStringExtra("mail");
            AdModel ad = new AdModel(title,address,imagePath,false,mail,numero,description);
            liste.add(ad);


        }*/
        dbManager = DBManager.getDBManager(this);
        //dbManager.init();

        // Ouvre la connexion à la base de données
        dbManager.open();
        //dbManager.init();

        // Récupère les données depuis la base de données
        Cursor cursor = dbManager.fetch();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdAdapter adapter = new RecyclerViewAdAdapter(this, cursor);

        // Configurez le RecyclerView avec un GridLayoutManager à deux colonnes
        int numberOfColumns = 2;
        GridLayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        /*recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AdModel item = liste.get(position);

                    Intent ad_view = new Intent(AdListViewActivity.this, AdViewActivity.class);
                    ad_view.putExtra("title", item.getTitle());
                    ad_view.putExtra("address", item.getAddress());
                    ad_view.putExtra("mail", item.getMail());
                    ad_view.putExtra("numero_de_telephone", item.getNumero_de_telephone());
                    ad_view.putExtra("image", item.getImage());
                    ad_view.putExtra("isDrawable",item.isDrawable);
                    ad_view.putExtra("description",item.getDescription());
                    startActivity(ad_view);

                }
            });
*/
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Ferme la connexion à la base de données lorsque l'activité est détruite
        dbManager.close();
    }
}
package com.example.leboncoin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    public static DBManager DBManager;

    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    DBManager(Context c) {
        context = c;
        //init(); // Useful for adding ads for the first time.
    }

    public static DBManager getDBManager(Context context) {
        if (DBManager == null){
            return new DBManager(context);
        }
        return DBManager;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    // Add ads manually.
    public void init(){
        open();
        insert(new DbAdModel(1, "test.jpg", "Raspberry pi 0W", "Carte Raspberry pi neuve, jamais utilisée, datant de 2020", 20, "Informatique", "Mathias", "8 Rue Colbrant, 59000 Lille", 645784922, "mathiasribeiro62@free.fr", "True"));
        insert(new DbAdModel(2, "test.jpg", "Aspirateur sans fil Dyson", "Aspirateur utilisé 1 an, très bon état, modèle : v15s detect submarine", 550, "Electroménager", "Jeanne", "75 Rue du 14 Juillet, 59113 Seclin", 611224457, "lopez.jeanne478@gmail.com", "True"));
        insert(new DbAdModel(3, "test.jpg", "Huawei P30", "Téléphone huawei, utilisé 1 an, arrière légèrement abîmé", 150, "Informatique", "Arnaud", "26 Rue Napoléon Demarquette, 62110 Hénin-Beaumont", 748755596, "arnaud59.tysiere@orange.fr", "True"));
        insert(new DbAdModel(4, "test.jpg", "Renault clio 3", "Renault Clio 3 en très bon état, CT fait, 180000km, prix : 4500€ non négociable", 4500, "Véhicule", "Hadoux", "263 Rue du Grand Bail, 59500 Douai", 675481923, "sylvie.adou@hotmail.fr", "True"));
        insert(new DbAdModel(5, "test.jpg", "Iphone 7", "Iphone 7 128Go, bon état, prix négociable", 80, "Informatique", "Julien", "12 Rue Gustave Deloeil, 59119 Waziers", 752468879, "simonin.julien@gmail.com", "True"));
        insert(new DbAdModel(6, "test.jpg", "Ordinateur Dell precision T1500", "Ordinateur Dell, processeur i5, 8Go de RAM, SSD 256Go", 250, "Informatique", "Christelle", "12 Rue des Capucins, 62000 Arras", 745132688, "christelle.trouf@gmail.com", "True"));
        insert(new DbAdModel(7, "test.jpg", "Samsung galaxy S20", "Ecran cassé en haut, prévoir réparation", 70, "Informatique", "Adam", "286 Cité du Bois d'Epinoy, 62820 Libercourt", 357468291, "adam.souffier@orange.fr", "True"));
        insert(new DbAdModel(8, "test.jpg", "Citroën C3 ", "Pare-choc légèrement rayé, 160000km, prix non négociable", 2500, "Véhicule", "Selim", "28 Rue Fernand Pantigny, 62590 Oignies", 383467958, "saphira.selim7@gmail.com", "True"));
        insert(new DbAdModel(9, "test.jpg", "T-shirt neuf", "T-shirt H&M jamais mis, ticket de caisse dispo", 5, "Mode", "Clément", "19 Rue de Douai, 59151 Arleux", 646593132, "clementdalinoux@proton.me", "True"));
        insert(new DbAdModel(10, "test.jpg", "Lave-vaisselle Bosch", "Lave-vaisselle en bon état, pas de problème technique, légers accros sur la porte, modèle SMS4ETI28E", 400, "Electroménager", "Pauline", "4 Rue Jean Baptiste Charcot, 62000 Dainville", 124521547, "hochiere.pauline@gmail.com", "True"));
        insert(new DbAdModel(11, "test.jpg", "Blender haute vitesse moulinex", "Blender modèle PERFECTMIX COOK 1400 W SILVER", 110, "Electroménager", "Lucie", "14 Rue Emile Combes, 62800 Liévin", 642152443, "lucie.salui@gmail.com", "True"));
        insert(new DbAdModel(12, "test.jpg", "Tente Forclaz 2 places ", "Tente 2 places, prix non négociable, achetée 250€", 160, "Sport", "Rémi", "29 Rue de Cambrai, 59169 Cantin", 724516243, "bachelot.remi@gmail.com", "True"));
        insert(new DbAdModel(13, "test.jpg", "Pull avec capuche Kiabi", "Pull rouge jamais porté, taille L", 15, "Mode", "Jean-Marc", "5 Rue du Kiosque, 59500 Douai", 643895315, "jean-marc.bolard@gmail.com", "True"));
        insert(new DbAdModel(14, "test.jpg", "Pantalon porté 1 an", "Pantalon de marque Kaporal, porté 1 an, trop petit pour moi, taille 42, vendu 25€", 25, "Mode", "Philippe", "34 Rue Pierre Brossolette, 59450 Sin-le-Noble", 125841628, "epiro.philippe@hotmail.fr", "True"));
        insert(new DbAdModel(15, "test.jpg", "Airmax", "Modèle : Air Max 1 Keep Rippin Stop Slippin", 120, "Sport", "Emeline", "10 Rue de la Liberté, 62119 Dourges", 964315211, "emeline.frunge@free.fr", "True"));
        insert(new DbAdModel(16, "test.jpg", "MacBook Pro 13 pouces", "MacBook Pro en excellent état, modèle 2019, SSD 512Go, RAM 8Go", 1100, "Informatique", "Pauline", "4 Rue Jean Baptiste Charcot, 62000 Dainville", 124521547, "hochiere.pauline@gmail.com", "True"));
        insert(new DbAdModel(17, "test.jpg", "Playstation 5", "Console PS5 neuve sous blister, garantie constructeur, jamais ouverte", 600, "Informatique", "Arnaud", "26 Rue Napoléon Demarquette, 62110 Hénin-Beaumont", 748755596, "arnaud59.tysiere@orange.fr", "True"));
        insert(new DbAdModel(18, "test.jpg", "Vélo de route Giant", "Vélo de course Giant, cadre carbone, équipement Shimano Ultegra, taille M", 1500, "Sport", "Rémi", "29 Rue de Cambrai, 59169 Cantin", 724516243, "bachelot.remi@gmail.com", "True"));
        insert(new DbAdModel(19, "test.jpg", "Table basse en bois massif", "Table basse artisanale en chêne, style moderne, état impeccable", 250, "Maison", "Julien", "12 Rue Gustave Deloeil, 59119 Waziers", 752468879, "simonin.julien@gmail.com", "True"));
        insert(new DbAdModel(20, "test.jpg", "Sac à dos North Face", "Sac à dos TNF, modèle Recon, parfait état, idéal pour la randonnée", 80, "Sport", "Jean-Marc", "5 Rue du Kiosque, 59500 Douai", 643895315, "jean-marc.bolard@gmail.com", "False"));
        insert(new DbAdModel(21, "test.jpg", "Montre connectée Apple Watch", "Apple Watch Series 6, GPS + Cellular, boîtier aluminium, bracelet sport", 300, "Informatique", "Adam", "286 Cité du Bois d'Epinoy, 62820 Libercourt", 357468291, "adam.souffier@orange.fr", "False"));
        insert(new DbAdModel(22, "test.jpg", "Chaussures de running Nike", "Chaussures de course Nike Air Zoom Pegasus, pointure 42, état neuf", 90, "Sport", "Julien", "12 Rue Gustave Deloeil, 59119 Waziers", 752468879, "simonin.julien@gmail.com", "False"));
        insert(new DbAdModel(23, "test.jpg", "Canapé d'angle convertible", "Canapé d'angle en tissu, convertible, couleur gris clair, très confortable", 700, "Maison", "Christelle", "12 Rue des Capucins, 62000 Arras", 745132688, "christelle.trouf@gmail.com", "False"));
        insert(new DbAdModel(24, "test.jpg", "Appareil photo Canon EOS", "Canon EOS 80D, objectif 18-135mm, excellent état, peu utilisé", 800, "Informatique", "Selim", "28 Rue Fernand Pantigny, 62590 Oignies", 383467958, "saphira.selim7@gmail.com", "False"));
        insert(new DbAdModel(25, "test.jpg", "Enceinte Bluetooth JBL", "Enceinte JBL Charge 4, waterproof, autonomie longue durée, comme neuve", 100, "Musique", "Jeanne", "75 Rue du 14 Juillet, 59113 Seclin", 611224457, "lopez.jeanne478@gmail.com", "False"));
        insert(new DbAdModel(26, "test.jpg", "Skateboard électrique", "Skateboard électrique Boosted Mini X, autonomie 22 km, vitesse max 32 km/h", 500, "Sport", "Mathias", "8 Rue Colbrant, 59000 Lille", 645784922, "mathiasribeiro62@free.fr", "False"));
        insert(new DbAdModel(27, "test.jpg", "Guitare électrique Fender", "Guitare Fender Stratocaster American Professional, sunburst, état impeccable", 900, "Musique", "Rémi", "29 Rue de Cambrai, 59169 Cantin", 724516243, "bachelot.remi@gmail.com", "False"));
        insert(new DbAdModel(28, "test.jpg", "Imprimante multifonction HP", "Imprimante HP OfficeJet Pro 9025, wifi, fax, scanner, comme neuve", 150, "Informatique", "Clément", "19 Rue de Douai, 59151 Arleux", 646593132, "clementdalinoux@proton.me", "False"));
        insert(new DbAdModel(29, "test.jpg", "Barbecue Weber", "Barbecue à gaz Weber Spirit II E-310, utilisé seulement quelques fois, comme neuf", 300, "Maison", "Arnaud", "26 Rue Napoléon Demarquette, 62110 Hénin-Beaumont", 748755596, "arnaud59.tysiere@orange.fr", "False"));
        insert(new DbAdModel(30, "test.jpg", "Chaise de bureau ergonomique", "Chaise de bureau IKEA Markus, réglable en hauteur, excellent soutien lombaire", 80, "Maison", "Emeline", "10 Rue de la Liberté, 62119 Dourges", 964315211, "emeline.frunge@free.fr", "False"));
        insert(new DbAdModel(31, "test.jpg", "Sac à main Louis Vuitton", "Sac à main Louis Vuitton Speedy Bandoulière 30, modèle classique, authentique", 1000, "Mode", "Philippe", "34 Rue Pierre Brossolette, 59450 Sin-le-Noble", 125841628, "epiro.philippe@hotmail.fr", "False"));
        insert(new DbAdModel(32, "test.jpg", "Drone DJI Mavic Air 2", "Drone DJI Mavic Air 2 Fly More Combo, utilisé une seule fois, état parfait", 800, "Sport", "Lucie", "14 Rue Emile Combes, 62800 Liévin", 642152443, "lucie.salui@gmail.com", "False"));
        insert(new DbAdModel(33, "test.jpg", "Veste en cuir véritable", "Veste en cuir véritable, taille M, style vintage, excellente qualité", 200, "Mode", "Hadoux", "263 Rue du Grand Bail, 59500 Douai", 675481923, "sylvie.adou@hotmail.fr", "False"));
        insert(new DbAdModel(34, "test.jpg", "Téléviseur Samsung 55 pouces", "TV Samsung 4K UHD Smart TV, modèle Crystal UHD TU8000, comme neuf", 600, "Maison", "Pauline", "4 Rue Jean Baptiste Charcot, 62000 Dainville", 124521547, "hochiere.pauline@gmail.com", "False"));
    }

    public void insert(DbAdModel ad) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DBHelper._ID, ad.getId());
        contentValue.put(DBHelper.IMAGE, ad.getImage());
        contentValue.put(DBHelper.TITLE, ad.getTitle());
        contentValue.put(DBHelper.DESCRIPTION, ad.getDescription());
        contentValue.put(DBHelper.PRICE, ad.getPrice());
        contentValue.put(DBHelper.CATEGORY, ad.getCategory());
        contentValue.put(DBHelper.SELLER, ad.getSeller());
        contentValue.put(DBHelper.ADDRESS, ad.getAddress());
        contentValue.put(DBHelper.TELEPHONE, ad.getTelephone());
        contentValue.put(DBHelper.MAIL, ad.getMail());
        contentValue.put(DBHelper.IS_AVAILABLE, ad.getIs_available());

        database.insert(DBHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DBHelper._ID, DBHelper.IMAGE, DBHelper.TITLE, DBHelper.DESCRIPTION, DBHelper.PRICE, DBHelper.CATEGORY, DBHelper.SELLER, DBHelper.ADDRESS, DBHelper.TELEPHONE, DBHelper.MAIL, DBHelper.IS_AVAILABLE };
        Cursor cursor = database.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, DbAdModel ad) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper._ID, ad.getId());
        contentValues.put(DBHelper.IMAGE, ad.getImage());
        contentValues.put(DBHelper.TITLE, ad.getTitle());
        contentValues.put(DBHelper.DESCRIPTION, ad.getDescription());
        contentValues.put(DBHelper.PRICE, ad.getPrice());
        contentValues.put(DBHelper.CATEGORY, ad.getCategory());
        contentValues.put(DBHelper.SELLER, ad.getSeller());
        contentValues.put(DBHelper.ADDRESS, ad.getAddress());
        contentValues.put(DBHelper.TELEPHONE, ad.getTelephone());
        contentValues.put(DBHelper.MAIL, ad.getMail());
        contentValues.put(DBHelper.IS_AVAILABLE, ad.getIs_available());

        int i = database.update(DBHelper.TABLE_NAME, contentValues, DBHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DBHelper.TABLE_NAME, DBHelper._ID + "=" + _id, null);
    }

    public DbAdModel getById(int id){
        return dbHelper.getById(id);
    }
}

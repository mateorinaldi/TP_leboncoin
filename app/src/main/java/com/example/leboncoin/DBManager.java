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
        init(); // Useful for adding ads for the first time.
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
        insert(new DbAdModel(15, "test.jpg", "titre", "description", 450, "electronique", "hadoux", "\n263 rue du grand bail, 59500 DOUAI", 64587, "mateo.riri", "true"));

        //insert(new DbAdModel("Wood", "Douai", "https://media.istockphoto.com/id/134253640/photo/construction-of-a-wooden-roof-frame-underway.jpg?s=612x612&w=0&k=20&c=e5gUkic9LGQWahIdHozOsEzHKy_HtsmvmtOHmYsejSU="));
        //insert(new DbAdModel("Steel", "Lille", "https://as2.ftcdn.net/v2/jpg/03/91/83/87/1000_F_391838708_4HFADW5beay2VVlnoual6Qi5fWeIaD9V.jpg"));
        //insert(new DbAdModel("Clay", "Douai", "https://constrofacilitator.com/wp-content/uploads/2020/02/clay-in-construction.jpg"));
        //insert(new DbAdModel("Metal", "Lyon", "https://www.meto-constructions.fr/wp-content/uploads/2018/12/IMG_6067.jpg"));
        //insert(new DbAdModel("Glass", "Valenciennes", "https://i0.wp.com/www.tipsnepal.com/wp-content/uploads/2020/09/simple-float-glass-1505049573-3306125.jpeg?resize=500%2C317&quality=100&strip=all&ssl=1"));
        //insert(new DbAdModel("Wood", "Orchies", "https://yieldpro.com/wp-content/uploads/2020/08/lumber1.jpg"));
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
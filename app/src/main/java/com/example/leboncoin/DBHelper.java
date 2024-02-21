package com.example.leboncoin;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    // Table Name
    public static final String TABLE_NAME = "annonces";

    // Table columns
    public static final String _ID = "_id";
    public static final String TITLE = "Titre";
    public static final String ADDRESS = "adresse";
    public static final String IMAGE = "image_path";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String CATEGORY = "category";
    public static final String SELLER = "seller";
    public static final String TELEPHONE = "telephone";
    public static final String MAIL = "mail";
    public static final String IS_AVAILABLE = "is_available";

    // Database Information
    static final String DB_NAME = "leboncoin.db";

    // database version
    static final int DB_VERSION = 10;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID + " INTEGER, "
            + IMAGE + " TEXT, " + TITLE + " TEXT, " + DESCRIPTION + " TEXT, " + PRICE + " INTEGER, " + CATEGORY + " TEXT, "
            + SELLER + " TEXT, " + ADDRESS + " TEXT, " + TELEPHONE + " INTEGER, " + MAIL + " TEXT, " + IS_AVAILABLE + " TEXT);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Util if you want to add a clicklistener on specific ad in listview.
    public DbAdModel getById(long id) {
        SQLiteDatabase db=this.getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME+" where "+ _ID + "=?";
        Cursor data = db.rawQuery(query,new String[] {String.valueOf(id)});
        if (data != null) {
            data.moveToFirst();
        }
        else{
            return null;
        }

        int id_article = data.getInt(data.getColumnIndexOrThrow(_ID));
        String title = data.getString(data.getColumnIndexOrThrow(TITLE));
        String address = data.getString(data.getColumnIndexOrThrow(ADDRESS));
        String image = data.getString(data.getColumnIndexOrThrow(IMAGE));
        String description = data.getString(data.getColumnIndexOrThrow(DESCRIPTION));
        int price = data.getInt(data.getColumnIndexOrThrow(PRICE));
        String category = data.getString(data.getColumnIndexOrThrow(CATEGORY));
        String seller = data.getString(data.getColumnIndexOrThrow(SELLER));
        int telephone = data.getInt(data.getColumnIndexOrThrow(TELEPHONE));
        String mail = data.getString(data.getColumnIndexOrThrow(MAIL));
        String is_available = data.getString(data.getColumnIndexOrThrow(IS_AVAILABLE));

        return new DbAdModel(id_article, image, title, description, price, category, seller, address, telephone, mail, is_available);
    }
}

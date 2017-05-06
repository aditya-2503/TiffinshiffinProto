package com.example.hp.slideactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP on 11/25/2016.
 */

public class Dbhandl extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MenuCard";

    // Contacts table name
    private static final String TABLE_CONTACTS = "menu";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_Brk = "breakfast";
    private static final String KEY_Lu = "lunch";
    private static final String KEY_Di = "dinner";

    public Dbhandl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_Brk + " TEXT,"
                + KEY_Lu + " TEXT," + KEY_Di+" TEXT"+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }
    public void addMenu(Schemadb sch) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, sch.getId());
        values.put(KEY_Brk, sch.getBreakfast());
        values.put(KEY_Lu,sch.getLunch());
        values.put(KEY_Di,sch.getDinner());


        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
    public Schemadb getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_Brk, KEY_Lu,KEY_Di }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null,null
        );
        if (cursor != null)
            cursor.moveToFirst();

        Schemadb sdb = new Schemadb(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3));
        // return contact
        db.close();
        return sdb;
    }
}

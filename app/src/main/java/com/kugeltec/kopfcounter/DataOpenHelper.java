package com.kugeltec.kopfcounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataOpenHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "data";
    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (date TEXT, place INT);";

    DataOpenHelper(Context context) {
        super(context, TABLE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putData(String date, int place) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("date", date);
        values.put("place", place);
        long newRowId;
        newRowId = db.insert(TABLE_NAME, null, values);
    }
}
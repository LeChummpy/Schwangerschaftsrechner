package com.example.schwangerschaftsrechnerentwurf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabseHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "appentries";
    private static final String TABLE_NAME = "patients";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FIRSTNAME = "first_name";
    private static final String COLUMN_SURENAME = "sure_name";
    private static final String COLUMN_DOLA = "dola";
    private static final String COLUMN_ADOP = "adop";

    public DatabseHandler (Context context){
        super(context, DB_NAME, null, DB_VERSION);
        SQLiteDatabase DB = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( '" + COLUMN_ID + "' INTEGER PRIMARY KEY AUTOINCREMENT, '" + COLUMN_FIRSTNAME + "' VARCHAR (10), '" + COLUMN_SURENAME + "' VARCHAR (10), '" + COLUMN_DOLA + "' VARCHAR (10), '" + COLUMN_ADOP + "' VARCHAR (10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public int insertData(String first_name, String surename, String dola, String adop){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRSTNAME, first_name);
        contentValues.put(COLUMN_SURENAME, surename);
        contentValues.put(COLUMN_DOLA, dola);
        contentValues.put(COLUMN_ADOP, adop);

        //if insert not successfull, insert returns a -1

        long result = DB.insert(TABLE_NAME, null, contentValues);

        if (result == -1) return 0;
        else return 1;
    }

    public Cursor getContent(){
        SQLiteDatabase DB = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data_cursor = DB.rawQuery(query, null);
        return data_cursor;
    }
}

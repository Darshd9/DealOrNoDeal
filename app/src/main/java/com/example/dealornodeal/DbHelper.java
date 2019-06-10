package com.example.dealornodeal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.provider.BaseColumns;

public class DbHelper extends SQLiteOpenHelper {

    public static class Titles implements BaseColumns {
        private static final String TABLE_Name = "Cases_Table";
        private static final String COL1 = "Case_Number";
        private static final String COL2 = "Value";
        private static final String COL3 = "Status";
    }

    Case aCase;

    public DbHelper(Context context) {
        super(context, Titles.TABLE_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + Titles.TABLE_Name + " (" + Titles._ID + " INTEGER PRIMARY KEY," +
                Titles.COL1 + " INTEGER," + Titles.COL2 + " INTEGER," + Titles.COL3 + " INTEGER)";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Titles.TABLE_Name);
        onCreate(db);

    }

    public boolean addCase(int num, int value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Titles.COL1, num);
        contentValues.put(Titles.COL2, value);
        contentValues.put(Titles.COL3, 0);

        long result = db.insert(Titles.TABLE_Name, null, contentValues);


        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public void clearData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Titles.TABLE_Name, null, null);
    }

    public boolean updateData(Case aCase) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Titles.COL1, aCase.getNum());
        contentValues.put(Titles.COL2, aCase.getValue());
        contentValues.put(Titles.COL3, aCase.getStatus());


        String id = String.valueOf(aCase.getNum());

        long result = db.update(Titles.TABLE_Name, contentValues, "Case_Number = ?", new String[] { id });
        if (result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + Titles.TABLE_Name;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getCaseInfo(int num) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + Titles.TABLE_Name +
                " WHERE " + Titles.COL1 + " = '" + num + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }
}

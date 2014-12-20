package com.bytech.controls;

import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bytech.lib.DBClass;
import com.bytech.models.App;

public class AppLogic implements AppInterface {

    DBClass database;

    public AppLogic(Context c) {
        database = new DBClass(c);
    }

    @Override
    public void add(App a) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("key", a.getKey());
        values.put("value", a.getValue());

        db.insert("app", null, values);
        db.close();

    }

    @Override
    public void update(String key, App a) {

    }

    @Override
    public void remove(String key) {
        SQLiteDatabase db = database.getWritableDatabase();
        String str = "Delete From app Where key = " + key;

        db.execSQL(str);
        db.close();

    }

    public void remove() {
        SQLiteDatabase db = database.getWritableDatabase();
        String str = "Delete From app";

        db.execSQL(str);
        db.close();

    }

    @Override
    public String get(String key) {

        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cur = db.rawQuery("Select value from app " + "Where key='"
                + key.toLowerCase() + "'", null);

        String val = "";
        if (cur.moveToFirst()) {
            do {
                val = cur.getString(cur.getColumnIndex("value"));

            } while (cur.moveToNext());
        }

        cur.close();
        db.close();

        return val;
    }

    @Override
    public HashMap<String, String> get() {

        return null;
    }

}

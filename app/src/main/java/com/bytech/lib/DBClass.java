package com.bytech.lib;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBClass extends SQLiteOpenHelper {

    public DBClass(Context context) {
        super(context, "webapk", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE if not exists app "
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "key TEXT, "
                + "value TEXT);");

        // type --> 1:menu, 2:news, 3:promo, >3:item-menu
        db.execSQL("CREATE TABLE if not exists cats "
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "cats_name TEXT, cats_desc TEXT, cats_type INT, cats_id INT);");

        db.execSQL("CREATE TABLE if not exists content "
                + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "content_title TEXT, content_desc TEXT, content_img TEXT, "
                + "content_post DATE, content_var TEXT, cats_id INT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

}
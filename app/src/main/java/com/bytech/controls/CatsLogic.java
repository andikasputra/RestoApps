package com.bytech.controls;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bytech.lib.DBClass;
import com.bytech.models.Cats;

public class CatsLogic implements CatsInterface {

    DBClass database;

    public CatsLogic(Context c) {
        database = new DBClass(c);
    }

    @Override
    public void add(Cats c) {

        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("cats_id", c.getCatsId());
        values.put("cats_type", c.getCatsType());
        values.put("cats_name", c.getCatsName());
        values.put("cats_desc", c.getCatsDesc());

        db.insert("cats", null, values);
        db.close();

    }

    @Override
    public void update(String key, Cats a) {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(String key) {
        // TODO Auto-generated method stub

    }

    @Override
    public String get(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Cats> get() {

        return null;
    }

    public List<Cats> getCatsMenu() {
        List<Cats> list = new ArrayList<Cats>();

        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cur = db
                .rawQuery(
                        "Select _id, cats_name, cats_desc, cats_type, cats_id, "
                                + "(select content_img from content where cats_id = cats.cats_id order by random() limit 1) as cats_img "
                                + "From cats Where cats_type > 3", null);

        if (cur.moveToFirst()) {
            do {
                Cats c = new Cats() {
                };
                c.set_id(cur.getInt(cur.getColumnIndex("_id")));
                c.setCatsId(cur.getInt(cur.getColumnIndex("cats_id")));
                c.setCatsName(cur.getString(cur.getColumnIndex("cats_name")));
                c.setCatsDesc(cur.getString(cur.getColumnIndex("cats_desc")));
                c.setCatsType(cur.getInt(cur.getColumnIndex("cats_type")));
                c.setCatsImg(cur.getString(cur.getColumnIndex("cats_img")));

                list.add(c);
            } while (cur.moveToNext());
        }

        cur.close();
        db.close();

        return list;
    }

    public void remove() {
        SQLiteDatabase db = database.getWritableDatabase();
        String str = "Delete From cats";

        db.execSQL(str);
        db.close();

    }

}

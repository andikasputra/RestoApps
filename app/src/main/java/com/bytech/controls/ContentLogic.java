package com.bytech.controls;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bytech.lib.DBClass;
import com.bytech.models.Content;

public class ContentLogic implements ContentInterface {

    DBClass database;

    public ContentLogic(Context c) {
        database = new DBClass(c);
    }

    @Override
    public void add(Content c) {
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("cats_id", c.getCatsId());
        values.put("content_title", c.getContentTitle());
        values.put("content_desc", c.getContentDesc());
        values.put("content_img", c.getContentImg());
        values.put("content_post", c.getContentPost());
        values.put("content_var", c.getContentVar());

        db.insert("content", null, values);
        db.close();

    }

    @Override
    public void update(String key, Content c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(String key) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Content> get(int cid) {
        List<Content> list = new ArrayList<Content>();

        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cur = db
                .rawQuery(
                        "Select content._id, content_title, content_desc, content_img, content_post, content_var, cats.cats_id "
                                + "From content Join cats on cats.cats_id = content.cats_id Where cats_type ="
                                + cid, null);

        if (cur.moveToFirst()) {
            do {
                Content c = new Content() {
                };
                c.set_id(cur.getInt(cur.getColumnIndex("_id")));
                c.setCatsId(cur.getInt(cur.getColumnIndex("cats_id")));
                c.setContentTitle(cur.getString(cur
                        .getColumnIndex("content_title")));
                c.setContentDesc(cur.getString(cur
                        .getColumnIndex("content_desc")));
                c.setContentImg(cur.getString(cur.getColumnIndex("content_img")));
                c.setContentPost(cur.getString(cur
                        .getColumnIndex("content_post")));
                c.setContentVar(cur.getString(cur.getColumnIndex("content_var")));

                list.add(c);
            } while (cur.moveToNext());
        }

        cur.close();
        db.close();

        return list;
    }

    public void remove() {
        SQLiteDatabase db = database.getWritableDatabase();
        String str = "Delete From content";

        db.execSQL(str);
        db.close();

    }

    @Override
    public List<Content> getId(int id) {
        List<Content> list = new ArrayList<Content>();

        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cur = db
                .rawQuery(
                        "Select content._id, content_title, cats_id, content_desc, content_img, content_post, content_var "
                                + "From content Where cats_id =" + id, null);

        if (cur.moveToFirst()) {
            do {
                Content c = new Content() {
                };
                c.set_id(cur.getInt(cur.getColumnIndex("_id")));
                c.setCatsId(cur.getInt(cur.getColumnIndex("cats_id")));
                c.setContentTitle(cur.getString(cur
                        .getColumnIndex("content_title")));
                c.setContentDesc(cur.getString(cur
                        .getColumnIndex("content_desc")));
                c.setContentImg(cur.getString(cur.getColumnIndex("content_img")));
                c.setContentPost(cur.getString(cur
                        .getColumnIndex("content_post")));
                c.setContentVar(cur.getString(cur.getColumnIndex("content_var")));

                list.add(c);
            } while (cur.moveToNext());
        }

        cur.close();
        db.close();

        return list;
    }

    @Override
    public Content getDetail(int id) {
        SQLiteDatabase db = database.getWritableDatabase();
        Cursor cur = db
                .rawQuery(
                        "Select content._id, content_title, cats_id, content_desc, content_img, content_post, content_var "
                                + "From content Where _id =" + id, null);
        Content c = new Content() {
        };

        if (cur.moveToFirst()) {

            c.set_id(cur.getInt(cur.getColumnIndex("_id")));
            c.setCatsId(cur.getInt(cur.getColumnIndex("cats_id")));
            c.setContentTitle(cur.getString(cur.getColumnIndex("content_title")));
            c.setContentDesc(cur.getString(cur.getColumnIndex("content_desc")));
            c.setContentImg(cur.getString(cur.getColumnIndex("content_img")));
            c.setContentPost(cur.getString(cur.getColumnIndex("content_post")));
            c.setContentVar(cur.getString(cur.getColumnIndex("content_var")));

        }

        cur.close();
        db.close();

        return c;

    }

}

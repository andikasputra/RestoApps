package com.bytech.lib;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.bytech.controls.AppLogic;
import com.bytech.controls.CatsLogic;
import com.bytech.controls.ContentLogic;
import com.bytech.models.App;
import com.bytech.models.Cats;
import com.bytech.models.Content;

public class FetchJson {

    String uri;
    String id;
    String web;
    Config cfg;
    Context context;
    boolean res;
    HttpConnect http;

    public FetchJson(Context c) {
        cfg = new Config();
        uri = cfg.getWeburi();
        id = cfg.getAppid();
        web = cfg.getBaseuri();
        context = c;

        http = new HttpConnect(uri + "resto/?id=" + id);
        res = http.getData();
    }

    public boolean getConnection() {
        return res;
    }

    // String data
    // 0 - fullname
    // 1 - email
    // 2 - phone
    // 3 - comment
    public boolean postFeedback(String[] data) {
        HttpConnect conn = new HttpConnect(uri + "feedback", 5);

        conn.addVar("resto_id", id);
        conn.addVar("fullname", data[0]);
        conn.addVar("email", data[1]);
        conn.addVar("phone", data[2]);
        conn.addVar("comment", data[3]);

        boolean rs = conn.postData();
        return rs;
    }

    public boolean checkVersion() {

        if (getConnection()) {
            String output = http.getOutput();
            try {
                JSONObject json = new JSONObject(output);

                AppLogic app = new AppLogic(context);

                String verServer = json.getString("resto_version");
                String verLocal = (app.get("resto_version").isEmpty()) ? "0"
                        : app.get("resto_version");

                if (Integer.parseInt(verServer) > Integer.parseInt(verLocal)) {
                    return true;
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public void saveResto() {

        String output = http.getOutput();
        try {
            JSONObject json = new JSONObject(output);
            AppLogic app = new AppLogic(context);

            @SuppressWarnings("rawtypes")
            Iterator keys = json.keys();
            App a = new App() {
            };

            app.remove();

            while (keys.hasNext()) {
                String keyName = (String) keys.next();
                a.setKey(keyName);
                a.setValue(json.getString(keyName));
                app.add(a);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void saveContent() {
        HttpConnect conn = new HttpConnect(uri + "data/?id=" + id);
        boolean rs = conn.getData();

        String output = conn.getOutput();
        if (rs) {
            try {
                JSONArray jsonArray = new JSONArray(output);
                ContentLogic cn = new ContentLogic(context);
                Content c = new Content() {
                };
                InternetHelper inet = new InternetHelper();

                cn.remove();

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject json = jsonArray.getJSONObject(i);
                    String[] img = json.getString("content_img").split("/");

                    c.setCatsId(json.getInt("categories_id"));
                    c.setContentTitle(json.getString("content_title"));
                    c.setContentDesc(json.getString("content_desc"));
                    c.setContentPost(json.getString("content_post"));
                    c.setContentImg(img[4]);
                    c.setContentVar(json.getString("content_var1"));

                    cn.add(c);

                    inet.downloadImage(web + json.getString("content_thumb"), img[4]);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    public void saveCats() {
        HttpConnect conn = new HttpConnect(uri + "cats/?id=" + id);
        boolean rs = conn.getData();

        String output = conn.getOutput();
        if (rs) {
            try {
                JSONArray jsonArray = new JSONArray(output);
                CatsLogic cn = new CatsLogic(context);
                Cats c = new Cats() {
                };

                cn.remove();

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject json = jsonArray.getJSONObject(i);

                    c.setCatsId(json.getInt("categories_id"));
                    c.setCatsType(json.getInt("category_type"));
                    c.setCatsName(json.getString("category_name"));
                    c.setCatsDesc(json.getString("category_desc"));

                    cn.add(c);

                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}

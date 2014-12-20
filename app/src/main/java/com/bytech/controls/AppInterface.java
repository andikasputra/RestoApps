package com.bytech.controls;

import java.util.HashMap;

import com.bytech.models.App;

public interface AppInterface {

    void add(App a);

    void update(String key, App a);

    void remove(String key);

    String get(String key);

    HashMap<String, String> get();

}

package com.bytech.models;

public abstract class App {

    private int _id;
    private String key;
    private String value;

    public App() {
    }

    public App(int _id, String key, String value) {
        super();
        this._id = _id;
        this.key = key;
        this.value = value;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return get_id() + "," + getKey() + "," + getValue();
    }

}

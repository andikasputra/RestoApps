package com.bytech.models;

public abstract class Cats {

    int _id;
    int catsType;
    int catsId;
    String catsName;
    String catsDesc;
    String catsImg;

    public Cats() {
        // TODO Auto-generated constructor stub
    }

    public Cats(int cats_type, int cats_id, String cats_name, String cats_desc, String cats_img) {
        super();
        this.catsType = cats_type;
        this.catsId = cats_id;
        this.catsName = cats_name;
        this.catsDesc = cats_desc;
        this.catsImg = cats_img;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getCatsType() {
        return catsType;
    }

    public void setCatsType(int cats_type) {
        this.catsType = cats_type;
    }

    public int getCatsId() {
        return catsId;
    }

    public void setCatsId(int cats_id) {
        this.catsId = cats_id;
    }

    public String getCatsName() {
        return catsName;
    }

    public void setCatsName(String cats_name) {
        this.catsName = cats_name;
    }

    public String getCatsDesc() {
        return catsDesc;
    }

    public void setCatsDesc(String cats_desc) {
        this.catsDesc = cats_desc;
    }

    public String getCatsImg() {
        return catsImg;
    }

    public void setCatsImg(String catsImg) {
        this.catsImg = catsImg;
    }


}

package com.bytech.models;

public abstract class Content {

    int _id;
    int catsId;
    String contentTitle;
    String contentDesc;
    String contentImg;
    String contentPost;
    String contentVar;

    public Content() {
        // TODO Auto-generated constructor stub
    }

    public Content(int cats_id, String content_title,
                   String content_desc, String content_img, String content_post,
                   String content_var) {
        super();
        this.catsId = cats_id;
        this.contentTitle = content_title;
        this.contentDesc = content_desc;
        this.contentImg = content_img;
        this.contentPost = content_post;
        this.contentVar = content_var;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getCatsId() {
        return catsId;
    }

    public void setCatsId(int catsId) {
        this.catsId = catsId;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc;
    }

    public String getContentImg() {
        return contentImg;
    }

    public void setContentImg(String contentImg) {
        this.contentImg = contentImg;
    }

    public String getContentPost() {
        return contentPost;
    }

    public void setContentPost(String contentPost) {
        this.contentPost = contentPost;
    }

    public String getContentVar() {
        return contentVar;
    }

    public void setContentVar(String contentVar) {
        this.contentVar = contentVar;
    }


}

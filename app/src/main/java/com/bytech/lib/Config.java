package com.bytech.lib;

public class Config {

    private String appid;
    private String weburi;
    private String baseuri;

    public Config() {
        super();

        appid = "41001";
        weburi = "http://app.bytechnology.biz/index.php/api/";
        baseuri = "http://app.bytechnology.biz";
    }

    public String getWeburi() {
        return weburi;
    }

    public void setWeburi(String weburi) {
        this.weburi = weburi;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getBaseuri() {
        return baseuri;
    }

    public void setBaseuri(String baseuri) {
        this.baseuri = baseuri;
    }


}

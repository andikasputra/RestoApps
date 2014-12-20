package com.bytech.restoapps;

import com.bytech.controls.AppLogic;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class AboutActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        AppLogic app = new AppLogic(this);

        TextView desc = (TextView) findViewById(R.id.txt_about_desc);
        desc.setText(app.get("resto_desc"));

        TextView addr = (TextView) findViewById(R.id.txt_about_addr);
        addr.setText(app.get("resto_address"));

        TextView email = (TextView) findViewById(R.id.txt_about_email);
        email.setText(app.get("resto_email"));

        TextView telp = (TextView) findViewById(R.id.txt_about_telp);
        telp.setText(app.get("resto_phone"));

        String mapUrl = "http://app.bytechnology.biz/index.php/login/map";

        WebView webview = (WebView) findViewById(R.id.map);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(mapUrl);

    }

}

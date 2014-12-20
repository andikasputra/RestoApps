package com.bytech.restoapps;

import com.bytech.lib.FetchJson;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashActivity extends Activity {

    public SplashActivity() {

    }

    public class loadUrl extends AsyncTask<String, String, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {

            FetchJson js = new FetchJson(SplashActivity.this);
            boolean res = js.getConnection();

            if (js.checkVersion() && res) {
                js.saveResto();
                js.saveCats();
                js.saveContent();
            }

            return res;

        }

        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);

            if (!result)
                Toast.makeText(
                        SplashActivity.this,
                        "Tidak dapat terhubung ke server, periksa koneksi internet anda dan cobalah beberapa saat lagi",
                        Toast.LENGTH_LONG).show();

            finish();

            Intent i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new loadUrl().execute();

    }

}
package com.bytech.restoapps;

import com.bytech.lib.FetchJson;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends Activity {

    EditText fullname, email, comment, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        fullname = (EditText) findViewById(R.id.editTextName);
        email = (EditText) findViewById(R.id.editTextEmail);
        phone = (EditText) findViewById(R.id.editTextPhone);
        comment = (EditText) findViewById(R.id.editTextMsg);

        Button post = (Button) findViewById(R.id.button_post);
        post.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new postFeedback().execute(fullname.getText().toString(), email
                                .getText().toString(), phone.getText().toString(),
                        comment.getText().toString());

            }
        });
    }

    public class postFeedback extends AsyncTask<String, String, Boolean> {

        private ProgressDialog dialog = new ProgressDialog(
                FeedbackActivity.this);

        String msg;

        public postFeedback() {
            msg = "ERROR: Tidak mengirim data, periksa koneksi jaringan anda";
        }

        @Override
        protected Boolean doInBackground(String... params) {

            boolean rs = false;
            if (!params[0].equals("") && !params[1].equals("")
                    && !params[3].equals("")) {
                FetchJson js = new FetchJson(FeedbackActivity.this);
                rs = js.postFeedback(params);
            } else
                msg = "ERROR: Nama, email dan komentar harus diisikan";

            return rs;
        }

        protected void onPreExecute() {
            dialog.setMessage("Proses mengirim data..");
            dialog.show();
        }

        protected void onPostExecute(Boolean result) {
            dialog.dismiss();
            if (result) {
                Toast.makeText(FeedbackActivity.this,
                        "Data berhasil dikirim ke server", Toast.LENGTH_SHORT)
                        .show();
                finish();
            } else {
                Toast.makeText(FeedbackActivity.this, msg, Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

}

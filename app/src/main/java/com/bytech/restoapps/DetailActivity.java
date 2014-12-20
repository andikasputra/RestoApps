package com.bytech.restoapps;

import java.io.File;
import java.text.DecimalFormat;

import com.bytech.controls.ContentLogic;
import com.bytech.lib.DateParse;
import com.bytech.lib.FileHelper;
import com.bytech.models.Content;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int id = getIntent().getExtras().getInt("id");
        String type = getIntent().getExtras().getString("type");

        Content c = null;

        setContentView(R.layout.activity_detail);

        ContentLogic cn = new ContentLogic(this);
        c = cn.getDetail(id);

        ImageView img = (ImageView) findViewById(R.id.img_menu);
        File f = new File(new FileHelper().getPath() + c.getContentImg());

        if (f.exists())
            img.setImageBitmap(BitmapFactory.decodeFile(f.getAbsolutePath()));

        TextView t1 = (TextView) findViewById(R.id.txt_menu1);
        t1.setText(c.getContentTitle());

        TextView t2 = (TextView) findViewById(R.id.txt_menu2);
        t2.setText(c.getContentDesc());

        TextView t3 = (TextView) findViewById(R.id.txt_menu3);

        if (type.equals("menu")) {
            DecimalFormat formatter = new DecimalFormat("#,###,###");
            String price = formatter
                    .format(Integer.parseInt(c.getContentVar()));
            t3.setText("Harga IDR " + price);

        } else if (type.equals("news")) {
            DateParse dp = new DateParse(c.getContentPost());
            t3.setText("Tanggal kirim " + dp.parseString());

        } else if (type.equals("promo")) {
            DateParse dp = new DateParse(c.getContentVar());
            t3.setText("Berlaku s/d tgl " + dp.parseNoTime());
            t3.setTextColor(Color.parseColor("#EF6C00"));

        }

    }

}

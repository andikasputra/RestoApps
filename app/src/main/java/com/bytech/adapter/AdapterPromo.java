package com.bytech.adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bytech.lib.FileHelper;
import com.bytech.models.Content;
import com.bytech.restoapps.DetailActivity;
import com.bytech.restoapps.R;

public class AdapterPromo extends BaseAdapter {

    ArrayList<Content> listPromo;

    public AdapterPromo(List<Content> m) {
        listPromo = new ArrayList<Content>(4);
        for (Content msg : m) {
            listPromo.add(msg);
        }
    }

    @Override
    public int getCount() {
        return listPromo.size();
    }

    @Override
    public Object getItem(int position) {
        return listPromo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, final ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.row_promo, parent, false);
        }

        final Content dataCn = listPromo.get(position);

        TextView txt1 = (TextView) view.findViewById(R.id.txt_promo1);
        txt1.setText(dataCn.getContentTitle());

        TextView txt2 = (TextView) view.findViewById(R.id.txt_promo2);
        txt2.setText(dataCn.getContentDesc());

        TextView txt3 = (TextView) view.findViewById(R.id.txt_promo3);
        txt3.setText("Berlaku s/d tgl " + dataCn.getContentVar());

        ImageView img = (ImageView) view.findViewById(R.id.img_promo);
        File f = new File(new FileHelper().getPath() + dataCn.getContentImg());

        if (f.exists())
            img.setImageBitmap(BitmapFactory.decodeFile(f.getAbsolutePath()));

        LinearLayout button = (LinearLayout) view.findViewById(R.id.ic_promo);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(parent.getContext(), DetailActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id", dataCn.get_id());
                intent.putExtra("type", "promo");
                parent.getContext().startActivity(intent);

            }
        });

        return view;
    }

}

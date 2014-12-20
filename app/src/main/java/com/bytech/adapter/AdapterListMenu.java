package com.bytech.adapter;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.bytech.lib.FileHelper;
import com.bytech.models.Content;
import com.bytech.restoapps.DetailActivity;
import com.bytech.restoapps.R;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AdapterListMenu extends BaseAdapter {

    ArrayList<Content> listCn;

    public AdapterListMenu(List<Content> m) {
        listCn = new ArrayList<Content>();
        for (Content c : m) {
            listCn.add(c);
        }
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listCn.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listCn.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View view, final ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.row_news, parent, false);
        }

        final Content dataCn = listCn.get(position);

        TextView txtMenu1 = (TextView) view.findViewById(R.id.txt_news1);
        txtMenu1.setText(dataCn.getContentTitle());

        TextView txtMenu2 = (TextView) view.findViewById(R.id.txt_news2);
        txtMenu2.setText(dataCn.getContentDesc());

        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String price = formatter.format(Integer.parseInt(dataCn.getContentVar()));
        TextView txtMenu3 = (TextView) view.findViewById(R.id.txt_news3);
        txtMenu3.setText("Harga IDR " + price);

        ImageView img = (ImageView) view.findViewById(R.id.img_news);
        File f = new File(new FileHelper().getPath() + dataCn.getContentImg());

        if (f.exists())
            img.setImageBitmap(BitmapFactory.decodeFile(f.getAbsolutePath()));

        LinearLayout button = (LinearLayout) view.findViewById(R.id.ic_news);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(parent.getContext(), DetailActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id", dataCn.get_id());
                intent.putExtra("type", "menu");
                parent.getContext().startActivity(intent);

            }
        });

        return view;
    }

}

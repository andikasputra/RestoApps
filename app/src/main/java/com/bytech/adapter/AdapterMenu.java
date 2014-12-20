package com.bytech.adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.bytech.lib.FileHelper;
import com.bytech.models.Cats;
import com.bytech.restoapps.MenuActivity;
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

public class AdapterMenu extends BaseAdapter {

    ArrayList<Cats> listCats;

    public AdapterMenu(List<Cats> m) {
        listCats = new ArrayList<Cats>();
        for (Cats c : m) {
            listCats.add(c);
        }
    }

    @Override
    public int getCount() {
        return listCats.size();
    }

    @Override
    public Object getItem(int position) {
        return listCats.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, final ViewGroup parent) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.row_menu, parent, false);
        }

        final Cats dataCats = listCats.get(position);

        TextView txtMenu1 = (TextView) view.findViewById(R.id.txt_menu1);
        txtMenu1.setText(dataCats.getCatsName());

        TextView txtMenu2 = (TextView) view.findViewById(R.id.txt_menu2);
        txtMenu2.setText(dataCats.getCatsDesc());

        ImageView img = (ImageView) view.findViewById(R.id.img_cats);
        File f = new File(new FileHelper().getPath() + dataCats.getCatsImg());

        if (f.exists())
            img.setImageBitmap(BitmapFactory.decodeFile(f.getAbsolutePath()));

        LinearLayout button = (LinearLayout) view.findViewById(R.id.ic_menu);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(parent.getContext(), MenuActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id", dataCats.getCatsId());
                parent.getContext().startActivity(intent);

            }
        });

        return view;
    }

}

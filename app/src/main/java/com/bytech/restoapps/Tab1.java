package com.bytech.restoapps;

import com.bytech.adapter.AdapterMenu;
import com.bytech.controls.AppLogic;
import com.bytech.controls.CatsLogic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class Tab1 extends ListFragment {

    ListView list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }

        View rootView = inflater.inflate(R.layout.list_fragment, null);

        AppLogic app = new AppLogic(getActivity());
        String desc = app.get("resto_desc");

        TextView txtDesc = (TextView) rootView.findViewById(R.id.txt_desc);
        txtDesc.setText(desc);

        txtDesc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),
                        AboutActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);

            }
        });

        CatsLogic c = new CatsLogic(getActivity());

        AdapterMenu statusAdapter = new AdapterMenu(c.getCatsMenu());

        setListAdapter(statusAdapter);

        return rootView;
    }

}

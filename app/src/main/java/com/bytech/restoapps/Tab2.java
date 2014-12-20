package com.bytech.restoapps;

import com.bytech.adapter.AdapterNews;
import com.bytech.controls.ContentLogic;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab2 extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }

        View rootView = inflater.inflate(R.layout.list_container, null);

        ContentLogic c = new ContentLogic(getActivity());

        AdapterNews statusAdapter = new AdapterNews(c.get(2));

        setListAdapter(statusAdapter);

        return rootView;
    }
}

package com.bytech.restoapps;

import com.bytech.adapter.AdapterListMenu;
import com.bytech.controls.ContentLogic;

import android.app.ListActivity;
import android.os.Bundle;

public class MenuActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_container);

        ContentLogic c = new ContentLogic(this);
        int id = getIntent().getExtras().getInt("id");

        AdapterListMenu statusAdapter = new AdapterListMenu(c.getId(id));

        setListAdapter(statusAdapter);

    }

}

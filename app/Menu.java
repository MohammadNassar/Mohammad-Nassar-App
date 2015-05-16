package com.example.hp.myapplication;

/** * Created by Mohammad Nassar on 15/12/2014. */
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

    String[] classes = {"MyActivity", "Intro", "Menu", "Option 1", "Option 2", "Option 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String aClass = classes[position];
        try {
            Class myActivityClass = Class.forName("com.example.hp.myapplication." + aClass);
            Intent openMyActivity = new Intent(Menu.this, myActivityClass);
            startActivity(openMyActivity);
        } catch (ClassNotFoundException e) {e.printStackTrace();}
    }
}

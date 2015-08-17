package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

/*** Created by GBY9C3HL on 12/08/2015.*/
public class Tabs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabSpec tabSpecs = tabHost.newTabSpec("tag1");
        tabSpecs.setContent(R.id.tab1);
        tabSpecs.setIndicator("Stop Watch");
        tabHost.addTab(tabSpecs);

        tabSpecs = tabHost.newTabSpec("tag2");
        tabSpecs.setContent(R.id.tab2);
        tabSpecs.setIndicator("Tab 2");
        tabHost.addTab(tabSpecs);

        tabSpecs = tabHost.newTabSpec("tag3");
        tabSpecs.setContent(R.id.tab3);
        tabSpecs.setIndicator("Add a Tab");
        tabHost.addTab(tabSpecs);
    }
}

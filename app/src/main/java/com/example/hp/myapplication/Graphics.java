package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;

/** * Created by Mohammad Nassar on 11/05/2015. */
public class Graphics extends Activity {

    MyBringBack theView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        theView = new MyBringBack(this);
        setContentView(theView);
    }
}

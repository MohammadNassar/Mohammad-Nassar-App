package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

/*** Created by GBY9C3HL on 01/09/2015. */
public class Flipper extends Activity implements View.OnClickListener {

    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flipper);

        flipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        flipper.setOnClickListener(this);
        flipper.setFlipInterval(500);
        flipper.startFlipping();
    }

    @Override
    public void onClick(View view) {
        flipper.showNext();
    }
}

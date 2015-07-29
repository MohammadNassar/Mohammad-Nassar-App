package com.example.hp.myapplication;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;

/** * Created by GBY9C3HL on 20/07/2015. */
public class Slider extends Activity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, SlidingDrawer.OnDrawerOpenListener {

    SlidingDrawer slidingDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding);

        slidingDrawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);

        CheckBox checkbox = (CheckBox) findViewById(R.id.checkBox);

        Button button1 = (Button) findViewById(R.id.sdButton1);
        Button button2 = (Button) findViewById(R.id.sdButton2);
        Button button3 = (Button) findViewById(R.id.sdButton3);
        Button button4 = (Button) findViewById(R.id.sdButton4);
        Button button5 = (Button) findViewById(R.id.sdButton5);

        slidingDrawer.setOnDrawerOpenListener(this);

        checkbox.setOnCheckedChangeListener(this);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if (compoundButton.isChecked()) {
            slidingDrawer.lock();
        }
        else {
            slidingDrawer.unlock();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.sdButton1:
                slidingDrawer.open();
            break;
            case R.id.sdButton2:

            break;
            case R.id.sdButton3:

            break;
            case R.id.sdButton4:
                slidingDrawer.close();
            break;
            case R.id.sdButton5:
                slidingDrawer.toggle();
            break;
        }
    }

    @Override
    public void onDrawerOpened() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.baby_laugh);
        mediaPlayer.start();
    }
}

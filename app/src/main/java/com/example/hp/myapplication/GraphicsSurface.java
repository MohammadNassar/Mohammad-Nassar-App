package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

/** * Created by Mohammad Nassar on 22/05/2015. */
public class GraphicsSurface extends Activity implements View.OnTouchListener {

    GraphicsSurfaceView theSurfaceView;
    float x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        theSurfaceView = new GraphicsSurfaceView(this);
        theSurfaceView.setOnTouchListener(this);
        x = 0;
        y = 0;
        setContentView(theSurfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        theSurfaceView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        theSurfaceView.resume();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        // The following two lines get the values of X and Y every time the screen is touched
        x = motionEvent.getX();
        y = motionEvent.getY();
        return false;
    }
}

package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;

/** * Created by Mohammad Nassar on 22/05/2015. */
public class GraphicsSurface extends Activity {

    GraphicsSurfaceView theSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        theSurfaceView = new GraphicsSurfaceView(this);
        setContentView(theSurfaceView);
    }
}

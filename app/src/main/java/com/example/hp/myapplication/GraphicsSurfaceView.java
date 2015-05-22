package com.example.hp.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/** * Created by Mohammad Nassar on 22/05/2015. */
public class GraphicsSurfaceView extends SurfaceView implements Runnable {

    SurfaceHolder theSurfaceHolder;
    Thread theThread = null;
    boolean isRunning = true;

    public GraphicsSurfaceView(Context context) {
        super(context);
        theSurfaceHolder = getHolder();
        theThread = new Thread();
        theThread.start();
    }

    @Override
    public void run() {

        while(isRunning) {

            if(!theSurfaceHolder.getSurface().isValid())
                continue;

            Canvas canvas = theSurfaceHolder.lockCanvas();
            canvas.drawRGB(205, 25, 150);
            theSurfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
}

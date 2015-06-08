package com.example.hp.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
        return true;
    }

    public class GraphicsSurfaceView extends SurfaceView implements Runnable {

        SurfaceHolder theSurfaceHolder;
        Thread theThread = null;
        boolean isRunning = false;

        public GraphicsSurfaceView(Context context) {
            super(context);
            theSurfaceHolder = getHolder();
        }

        public void pause() {

            isRunning = true;
            while(true) {
                try{
                    theThread.join();
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
                theThread = null;
            }
        }

        public void resume() {

            isRunning = true;
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
                if (x != 0 && y != 0) {
                    Bitmap test = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
                    canvas.drawBitmap(test, x-(test.getWidth()/2), y-(test.getHeight()/2), null);
                }
                theSurfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}

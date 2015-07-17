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
    // f for final, s for starting and d for direction
    float x, y, sX, sY, fX, fY, dX, dY, animateX, animateY, scaledX, scaledY;
    Bitmap test, plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        theSurfaceView = new GraphicsSurfaceView(this);
        theSurfaceView.setOnTouchListener(this);
        x = 0;
        y = 0;
        sX = 0;
        sY = 0;
        fX = 0;
        fY = 0;
        dX = dY = animateX = animateY = scaledX = scaledY = 0;
        test = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
        plus = BitmapFactory.decodeResource(getResources(), R.drawable.b_plus);
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

        try {
            Thread.sleep(50);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        // The following two lines get the values of X and Y every time the screen is touched
        x = motionEvent.getX();
        y = motionEvent.getY();

        switch(motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                sX = motionEvent.getX();
                sY = motionEvent.getY();
                dX = dY = animateX = animateY = scaledX = scaledY = fX = fY = 0;
                break;
            case MotionEvent.ACTION_UP:
                fX = motionEvent.getX();
                fY = motionEvent.getY();
                dX = fX - sX;
                dY = fX - sY;
                scaledX = dX/30;
                scaledY = dX/30;
                x = y = 0;
                break;
        }

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
                    canvas.drawBitmap(test, x-(test.getWidth()/2), y-(test.getHeight()/2), null);
                }
                if (sX != 0 && sY != 0) {
                    canvas.drawBitmap(plus, sX-(plus.getWidth()/2), sY-(plus.getHeight()/2), null);
                }
                if (fX != 0 && fY != 0) {
                    canvas.drawBitmap(test, fX-(test.getWidth()/2)-animateX, fY-(test.getHeight()/2)-animateY, null);
                    canvas.drawBitmap(plus, fX-(plus.getWidth()/2), fY-(plus.getHeight()/2), null);
                }
                animateX = animateX + scaledX;
                animateY = animateY + scaledX;

                theSurfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}

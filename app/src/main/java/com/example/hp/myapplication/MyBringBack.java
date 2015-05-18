package com.example.hp.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/** * Created by Mohammad Nassar on 11/05/2015. */
public class MyBringBack extends View {

    Bitmap gBall;
    float movingY;

    public MyBringBack(Context context) {
        super(context);
        gBall = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
        movingY = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(gBall, (canvas.getWidth()/2), movingY, null);
        if(movingY < canvas.getHeight()) {
            movingY += 5;
        }
        else {
            movingY = 0;
        }

        // Hence: The rectangle drawn below is not shown on Android Emulator!!
        Rect rectangle = new Rect();
        rectangle.set(0, 400, canvas.getWidth(), 550);
        Paint blueColor = new Paint();
        blueColor.setColor(Color.BLUE);
        canvas.drawRect(rectangle, blueColor);

        invalidate();
    }
}

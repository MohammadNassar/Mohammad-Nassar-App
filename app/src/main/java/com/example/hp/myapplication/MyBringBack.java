package com.example.hp.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/** * Created by Mohammad Nassar on 11/05/2015. */
public class MyBringBack extends View {

    Bitmap gBall;
    float movingY;
    Typeface font;

    public MyBringBack(Context context) {
        super(context);
        gBall = BitmapFactory.decodeResource(getResources(), R.drawable.greenball);
        movingY = 0;
        font = Typeface.createFromAsset(context.getAssets(), "Artbrush.ttf");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        Paint textPaint = new Paint();
        textPaint.setARGB(85, 175, 50, 200);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(35);
        textPaint.setTypeface(font);
        canvas.drawText("Mohammad Nassar", getWidth()/2, getHeight()/2, textPaint);

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

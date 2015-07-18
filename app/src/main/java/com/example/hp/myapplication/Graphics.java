package com.example.hp.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

/** * Created by Mohammad Nassar on 11/05/2015. */
public class Graphics extends Activity {

    GraphicsView theView;
    PowerManager.WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyWakelockTag");

        super.onCreate(savedInstanceState);

        wakeLock.acquire();

        theView = new GraphicsView(this);
        setContentView(theView);
    }

    @Override
    protected void onPause() {
        super.onPause();

        wakeLock.release();
    }

    @Override
    protected void onResume() {
        super.onResume();

        wakeLock.acquire();
    }
}

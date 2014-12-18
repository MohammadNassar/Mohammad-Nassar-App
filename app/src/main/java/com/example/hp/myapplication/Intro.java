package com.example.hp.myapplication;

/** * Created by hp on 15/12/2014. */
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;

public class Intro extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        MediaPlayer introSound = MediaPlayer.create(Intro.this, R.raw.intro_sound);
        introSound.start();
        // Thread Timer
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent openStartingPoint = new Intent(Intro.this, MyActivity.class);
                    startActivity(openStartingPoint);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause () {
        super.onPause();
        // Close this activity completely.
        //introSound.release();
        finish();
    }
}

package com.example.hp.myapplication;

/** * Created by Mohammad Nassar on 15/12/2014. */
import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.preference.PreferenceManager;

public class Intro extends Activity {

    MediaPlayer introSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        introSound = MediaPlayer.create(Intro.this, R.raw.intro_sound);
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean soundsOn = getPrefs.getBoolean("checkbox", true);
        if (soundsOn == true)
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
                    Intent openStartingPoint = new Intent(Intro.this, Menu.class);
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
        introSound.release(); // Just in case if sound is playing for too long, then it should end here.
        finish();
    }
}

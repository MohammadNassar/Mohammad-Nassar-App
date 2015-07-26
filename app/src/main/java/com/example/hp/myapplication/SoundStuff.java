package com.example.hp.myapplication;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

/** * Created by GBY9C3HL on 19/07/2015. */
public class SoundStuff extends Activity implements View.OnClickListener, View.OnLongClickListener {
    
    SoundPool soundPool;
    int bam = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = new View(this);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        setContentView(view);
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        mediaPlayer = MediaPlayer.create(this, R.raw.baby_laugh);

        //Accessing the sound from a resource
        bam = soundPool.load(this, R.raw.bam_sound, 1);
    }

    @Override
    public void onClick(View view) {
        // Play the sound
        if (bam != 0) {
            // Parameters passed are: sound to play [sound id], left volume[1=highest], right volume[1=highest],
            //      priority [0=lowest priority], loop [0=no loop], rate [1=playback normally]
            soundPool.play(bam, 1, 1, 0, 0, 1);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        // Play the long sound
        mediaPlayer.start();
        return false;
    }
}

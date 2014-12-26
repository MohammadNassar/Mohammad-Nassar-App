package com.example.hp.myapplication;

/** * Created by hp on 17/12/2014. */
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Text extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        Button checkButton = (Button) findViewById(R.id.bResults);
        ToggleButton passToggle = (ToggleButton) findViewById(R.id.tbPassword);
        EditText input = (EditText) findViewById(R.id.etCommand);
        TextView display = (TextView) findViewById(R.id.tvResults);
    }
}

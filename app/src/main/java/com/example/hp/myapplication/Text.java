package com.example.hp.myapplication;

/** * Created by hp on 17/12/2014. */
import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
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
        final ToggleButton passToggle = (ToggleButton) findViewById(R.id.tbPassword);
        final EditText input = (EditText) findViewById(R.id.etCommand);
        final TextView display = (TextView) findViewById(R.id.tvResults);

        passToggle.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                if (passToggle.isChecked()) {
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String checkStr = input.getText().toString();
                if (checkStr.contentEquals("left")) {
                    display.setGravity(Gravity.LEFT);
                } else if (checkStr.contentEquals("center")) {
                    display.setGravity(Gravity.CENTER);
                } else if (checkStr.contentEquals("right")) {
                    display.setGravity(Gravity.RIGHT);
                } else if (checkStr.contentEquals("blue")) {
                    
                }
            }
        });
    }
}

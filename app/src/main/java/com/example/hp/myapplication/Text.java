package com.example.hp.myapplication;

/** * Created by hp on 17/12/2014. */
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.Random;

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
                display.setText(checkStr);
                if (checkStr.contentEquals("start")) {
                    display.setGravity(Gravity.START);
                } else if (checkStr.contentEquals("center")) {
                    display.setGravity(Gravity.CENTER);
                } else if (checkStr.contentEquals("end")) {
                    display.setGravity(Gravity.END);
                } else if (checkStr.contentEquals("blue")) {
                    display.setTextColor(Color.BLUE);
                } else if (checkStr.contentEquals("?")) {
                    Random random = new Random();
                    display.setText("?????");
                    display.setTextSize(random.nextInt(100));
                    display.setTextColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                } else {
                    display.setText("invalid");
                    display.setGravity(Gravity.CENTER);
                }
            }
        });
    }
}

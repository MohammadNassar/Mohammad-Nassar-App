package com.example.hp.myapplication;

/** * Created by Mohammad Nassar on 17/12/2014. */
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

public class Text extends Activity implements View.OnClickListener {

    Button checkButton;
    ToggleButton passToggle;
    EditText input;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);

        initialiseVariables();

        passToggle.setOnClickListener(this);

        checkButton.setOnClickListener(this);
    }

    private void initialiseVariables() {

        checkButton = (Button) findViewById(R.id.bResults);
        passToggle = (ToggleButton) findViewById(R.id.tbPassword);
        input = (EditText) findViewById(R.id.etCommand);
        display = (TextView) findViewById(R.id.tvResults);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bResults :
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
                    switch (random.nextInt(3)) {
                        case 0 :
                            display.setGravity(Gravity.START);
                            break;
                        case 1 :
                            display.setGravity(Gravity.CENTER);
                            break;
                        case 2 :
                            display.setGravity(Gravity.END);
                            break;
                    }
                } else {
                    display.setText("invalid");
                    display.setGravity(Gravity.CENTER);
                    display.setTextColor(Color.WHITE);
                }
                break;
            case R.id.tbPassword :
                if (passToggle.isChecked()) {
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    input.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;
        }
    }
}

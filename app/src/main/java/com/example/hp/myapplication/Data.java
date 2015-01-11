package com.example.hp.myapplication;

/** * Created by hp on 09/01/2015. */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Data extends Activity implements View.OnClickListener {

    Button start, startFor;
    EditText sendET;
    TextView gotAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get);
        initialise();
    }

    private void initialise() {
        start = (Button) findViewById(R.id.bSA);
        startFor = (Button) findViewById(R.id.bSAFR);
        sendET = (EditText) findViewById(R.id.etSend);
        gotAnswer = (TextView) findViewById(R.id.tvGot);
        start.setOnClickListener(this);
        startFor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}

package com.example.hp.myapplication;

/** * Created by hp on 09/01/2015. */
import android.app.Activity;
import android.content.Intent;
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

        switch (view.getId()) {
            case R.id.bSA :
                String bread = sendET.getText().toString();
                // We'll send data through a Bundle
                //You can think of a bundle as a basket
                Bundle basket = new Bundle();
                //We're going to label the string file: 'bread' with the name: 'Key'.
                basket.putString("key", bread);
                //Now we setup an intent, to hold the context of our class: 'Data' and open the class: 'OpenedClass'
                Intent intent = new Intent(Data.this, OpenedClass.class);
                //Setup the basket/bundle within out intent
                intent.putExtras(basket);
                startActivity(intent);
                break;
            case R.id.bSAFR :

                break;
        }
    }
}

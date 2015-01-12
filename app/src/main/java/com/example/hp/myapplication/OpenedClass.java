package com.example.hp.myapplication;

/** * Created by hp on 09/01/2015. */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OpenedClass extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    TextView question, test;
    Button returnData;
    RadioGroup rgSelectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialise();
    }

    private void initialise() {
        question = (TextView) findViewById(R.id.tvQuestion);
        test = (TextView) findViewById(R.id.tvText);
        returnData = (Button) findViewById(R.id.bReturn);
        returnData.setOnClickListener(this);
        rgSelectionList.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.rBlue :

                break;

            case R.id.rGreen :

                break;

            case R.id.rBoth :

                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}

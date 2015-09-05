package com.example.hp.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*** Created by Mohammad Said Nassar on 05/09/2015. */
public class SharedPrefs extends Activity implements View.OnClickListener {

    EditText sharedData;
    TextView dataResults;
    public static String filename = "MySharedString";
    SharedPreferences myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferences);
        initVars();
        myData = getSharedPreferences(filename, 0);
    }

    private void initVars() {

        Button save = (Button) findViewById(R.id.bSave);
        Button load = (Button) findViewById(R.id.bLoad);
        sharedData = (EditText) findViewById(R.id.etSharedPrefs);
        dataResults = (TextView) findViewById(R.id.tvLoadSharedPrefs);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bSave :
                // Save the given text in the SharedPreferences using KEY-VALUE
                String stringData = sharedData.getText().toString();
                // Get the settings from the SharedPreferences
                SharedPreferences.Editor editor = myData.edit();
                // Using a KEY reference and applying a VALUE to it
                editor.putString("sharedString", stringData);
                // Finalise the work
                editor.commit();
                break;

            case R.id.bLoad :
                // Load the stored SharedPreferences data
                myData = getSharedPreferences(filename, 0);
                // First parameter is the data key, and the second is info to return if key was not found.
                String returnedData = myData.getString("sharedString", "Could not load data!");
                dataResults.setText(returnedData);
                break;
        }
    }
}

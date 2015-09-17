package com.example.hp.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/** * Created by Mohammad Said Nassar on 08/09/2015. */
public class InternalData extends Activity implements View.OnClickListener {

    EditText sharedData;
    TextView dataResults;
    FileOutputStream fos;
    String filename = "InternalString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internaldata);
        initVars();
    }

    private void initVars() {

        Button save = (Button) findViewById(R.id.bSave);
        Button load = (Button) findViewById(R.id.bLoad);
        sharedData = (EditText) findViewById(R.id.etSharedPrefs);
        dataResults = (TextView) findViewById(R.id.tvLoadSharedPrefs);
        save.setOnClickListener(this);
        load.setOnClickListener(this);
        try {
            // Creating our FileOutputStream using reference of the filename, writing data to it privately and finally closing it
            fos = openFileOutput(filename, Context.MODE_PRIVATE);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bSave :
                String data = sharedData.getText().toString();
                // Saving data via file
                // Way no. 1 :
                /*File file  = new File(filename);
                try {
                    fos = new FileOutputStream(file);
                    // Write some data to the file
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                // Way no. 1 :
                try {
                    fos = openFileOutput(filename, Context.MODE_PRIVATE);
                    fos.write(data.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.bLoad :
                new LoadSomeData().execute(filename);

                break;
        }
    }

    public class LoadSomeData extends AsyncTask<String, Integer, String> {

        protected void onPreExecute(String str) {
            str = "JustATest";
        }

        @Override
        protected String doInBackground(String... strings) {

            // Loading the FileOutputStream and display the  data
            FileInputStream fis = null;
            String collected = null;
            try {
                fis = openFileInput(filename);
                // Create a byte array with the same length of bytes in the FileInputStream
                byte[] dataArray = new byte[fis.available()];
                while (fis.read(dataArray) != -1) {
                    // Read all data in the file and store it in the 'collected' string variable
                    collected = new String(dataArray);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    // Finally lose the FileInputStream and display the read/gathered data
                    fis.close();
                    return collected;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        protected void onProgressUpdate(Integer...progress) {

        }

        protected void onPostExecute(String result) {
            dataResults.setText(result);
        }
    }
}

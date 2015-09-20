package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;

/*** Created by GBY9C3HL on 20/09/2015. */
public class ExternalData extends Activity {

    private TextView canRead, canWrite;
    private String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);

        canRead = (TextView) findViewById(R.id.tvCanRead);
        canWrite = (TextView) findViewById(R.id.tvCanWrite);
        canRead.setText("false");
        canWrite.setText("false");

        state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // Read and write
            canRead.setText("true");
            canWrite.setText("true");
        }
        else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            // Read only (cannot write)
            canRead.setText("true");
            canWrite.setText("false");
        }
        else {
            // Can neither read nor write
            canRead.setText("false");
            canWrite.setText("false");
        }
    }
}

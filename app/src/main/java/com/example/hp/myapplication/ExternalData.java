package com.example.hp.myapplication;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*** Created by GBY9C3HL on 20/09/2015. */
public class ExternalData extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    TextView canRead, canWrite;
    String state;
    boolean canR, canW;
    Spinner spinner;
    String[] paths = {"Music", "Pictures", "Download"};
    File path = null;
    File file = null;

    EditText saveFile;
    Button confirm, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.externaldata);

        canRead = (TextView) findViewById(R.id.tvCanRead);
        canWrite = (TextView) findViewById(R.id.tvCanWrite);
        canRead.setText("false");
        canWrite.setText("false");

        confirm = (Button) findViewById(R.id.bConfirmSaveAs);
        save = (Button) findViewById(R.id.bSaveFile);
        saveFile = (EditText) findViewById(R.id.etSaveAs);
        confirm.setOnClickListener(this);
        save.setOnClickListener(this);

        checkState();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paths);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void checkState() {

        state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // Read and write
            canRead.setText("true");
            canWrite.setText("true");
            canR = canW = true;
        }
        else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            // Read only (cannot write)
            canRead.setText("true");
            canWrite.setText("false");
            canR = true;
            canW = false;
        }
        else {
            // Can neither read nor write
            canRead.setText("false");
            canWrite.setText("false");
            canR = canW = false;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int position = spinner.getSelectedItemPosition();
        switch (position) {
            case 0:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
                break;
            case 1:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                break;
            case 2:
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bConfirmSaveAs:
                save.setVisibility(View.VISIBLE);
                break;
            case R.id.bSaveFile:
                String filenameFromEditText = saveFile.getText().toString();
                String extension = ".png";
                file = new File(path, filenameFromEditText + extension);
                checkState();

                if (canR == canW == true) {

                    // If path doesn't exist then create it
                    path.mkdirs();

                    try {
                        InputStream inputStream = getResources().openRawResource(R.drawable.greenball);
                        OutputStream outputStream = new FileOutputStream(file);
                        byte[] data = new byte[inputStream.available()];
                        inputStream.read();
                        outputStream.write(data);
                        inputStream.close();
                        outputStream.close();

                        Toast toast = Toast.makeText(this, "File has been saved.", Toast.LENGTH_LONG);
                        toast.show();

                        // Update files through the MediaScanner to make the new file available to the user.
                        MediaScannerConnection.scanFile(
                                this,
                                new String[] {file.toString()},
                                null,
                                new MediaScannerConnection.OnScanCompletedListener() {
                                    // Once the scan is complete, display a message confirming that scan is complete.
                                    @Override
                                    public void onScanCompleted(String path, Uri uri) {
                                        Toast toast = Toast.makeText(ExternalData.this, "Scan Complete", Toast.LENGTH_LONG);
                                        toast.show();
                                    }
                                });

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}

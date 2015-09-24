package com.example.hp.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*** Created by GBY9C3HL on 21/09/2015. */
public class SQLiteExample extends Activity implements View.OnClickListener {

    Button sqlUpdate, sqlView;
    EditText sqlName, sqlJavaSkill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteexample);

        sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
        sqlView = (Button) findViewById(R.id.bSQLView);
        sqlName = (EditText) findViewById(R.id.etSQLName);
        sqlJavaSkill = (EditText) findViewById(R.id.etSQLJavaSkill);

        sqlUpdate.setOnClickListener(this);
        sqlView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.bSQLUpdate :

                boolean didItWork = true;

                try {
                    String name = sqlName.getText().toString();
                    String skill= sqlJavaSkill.getText().toString();

                    PassOrNot entry = new PassOrNot(SQLiteExample.this);
                    entry.open();
                    // Inserting data on database
                    entry.createEntry(name, skill);
                    entry.close();
                } catch (Exception e) {
                    didItWork = false;
                } finally {
                    if (didItWork) {
                        Dialog dialog = new Dialog(this);
                        dialog.setTitle("It worked successfully!");
                        TextView textView = new TextView(this);
                        textView.setText("Success");
                        dialog.setContentView(textView);
                        dialog.show();
                    }
                }

                break;

            case R.id.bSQLView :

                Intent intent = new Intent("com.example.hp.myapplication.SQLVIEW");
                startActivity(intent);

                break;
        }
    }
}

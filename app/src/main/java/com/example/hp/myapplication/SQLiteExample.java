package com.example.hp.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                String name = sqlName.getText().toString();
                String skill= sqlJavaSkill.getText().toString();

                PassOrNot entry = new PassOrNot(SQLiteExample.this);
                entry.open();
                // To add data on database here
                entry.close();

                break;

            case R.id.bSQLView :


                break;
        }
    }
}

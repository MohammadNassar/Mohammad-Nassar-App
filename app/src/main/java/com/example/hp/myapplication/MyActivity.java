package com.example.hp.myapplication;

/** * Created by Mohammad Nassar on 30/12/2014. */
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {

    int counter;
    Button add, subtract;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        // Setting up variables and referencing XML IDs
        counter = 0;
        add = (Button) findViewById(R.id.bAdd);
        subtract = (Button) findViewById(R.id.bSubtract);
        display = (TextView) findViewById(R.id.tvDisplay);
        // Setting up a button with onClickListener
        add.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                counter++;
                display.setText("Total is: " + counter);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                counter--;
                display.setText("Total is: " + counter);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

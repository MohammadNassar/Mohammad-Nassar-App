package com.example.hp.myapplication;

/** * Created by Mohammad Nassar on 15/12/2014. */
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

    String[] classes = {"MyActivity", "Intro", "Menu", "Text", "Email", "Camera", "Data", "OpenedClass", "Prefs", "Graphics", "GraphicsSurface", "SoundStuff", "Slider", "Tabs", "SimpleBrowser", "Flipper", "SharedPrefs", "InternalData", "ExternalData", "SQLiteExample"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Fullscreen - (no text/logo at the top of the screen) [However, the next two lines of code do not work as expected!!]
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String aClass = classes[position];
        try {
            Class myActivityClass = Class.forName("com.example.hp.myapplication." + aClass);
            Intent openMyActivity = new Intent(Menu.this, myActivityClass);
            startActivity(openMyActivity);
        } catch (ClassNotFoundException e) {e.printStackTrace();}
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Here we set the action that happens when an item from the list is clicked
        switch(item.getItemId()) {
            case R.id.aboutUs:
                //Usual way of opening an activity
                Intent intentForAbout = new Intent("com.example.hp.myapplication.ABOUT");
                startActivity(intentForAbout);
                break;
            case R.id.preferences:
                Intent intentForPrefs = new Intent("com.example.hp.myapplication.Prefs");
                startActivity(intentForPrefs);
                break;
            case R.id.exit:
                finish();
                break;
        }
        return false;
    }
}

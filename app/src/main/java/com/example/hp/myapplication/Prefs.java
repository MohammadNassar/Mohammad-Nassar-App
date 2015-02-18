package com.example.hp.myapplication;
// PreferenceFragment - BugFix #1 has been committed on branch: 'PreferenceFragmentBugFix'
import android.os.Bundle;
import android.preference.PreferenceActivity;

/** * Created by Mohammad Nassar on 15/02/2015. */
public class Prefs extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}

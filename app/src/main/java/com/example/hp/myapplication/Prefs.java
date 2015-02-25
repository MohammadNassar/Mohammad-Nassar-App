package com.example.hp.myapplication;

/** * Created by Mohammad Nassar on 15/01/2015. */
// PreferenceFragment - BugFix #1 has been committed on branch: 'PreferenceFragmentBugFix'
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

/** * Created by Mohammad Nassar on 15/02/2015. */
public class Prefs extends PreferenceActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new PrefsFragment()).commit();
    }

    public static class PrefsFragment extends PreferenceFragment {

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.prefs);
        }
    }
}

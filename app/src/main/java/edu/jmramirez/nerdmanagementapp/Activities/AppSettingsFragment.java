package edu.jmramirez.nerdmanagementapp.Activities;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import edu.jmramirez.nerdmanagementapp.R;

public class AppSettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.layout.app_preferences);
    }
}

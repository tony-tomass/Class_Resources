package com.mobile.sharedpreferencesexample;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import androidx.annotation.Nullable;

/*
Creating a PreferenceActivity.java
 */
public class Preferences extends PreferenceActivity {

    SharedPreferences myPrefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        //You can access the preferences without specifying the file name, too.
        //Line 26 allows you to access the preference settings, even if you have
        //more than one preference XML file associated with a PreferenceActivity,
        //and they will be saved automatically when the user interacts with them
        myPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String username = myPrefs.getString("username", "None");
    }
}

package com.mobile.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";
    SharedPreferences prefs;
    int currentOrientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Added; 0 = the created file can only be accessed by the calling app
        // or all apps sharing the same user ID
        prefs = getSharedPreferences(PREFS_NAME, 0);

        // Added; Example using preferences and booleans with dummy method
        boolean silent = prefs.getBoolean("silentMode", false);
        //setSilent(silent);

        String futureMessage = "";

        if(!futureMessage.equals("")){
            TextView messageView = findViewById(R.id.message);
            messageView.setText(futureMessage);
        }
    }

    // Added; Want data to persist when app is terminated
    @Override
    protected void onStop() {
        super.onStop();

        //Gets reference to preference; should have that silent boolean set by now
        prefs = getSharedPreferences(PREFS_NAME, 0);

        //Need an editor to modify contents of SharedPreferences file
        SharedPreferences.Editor editor = prefs.edit();

        //Sets value of silentMode to boolean value of mSilentMode (dummy)
        //editor.putBoolean("silentMode", mSilentMode);
        //Save changes to file by committing
        editor.commit();
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = prefs.edit();
        EditText messageBox = findViewById(R.id.MessageInput);
        editor.putString("futureMessage", messageBox.getText().toString());
        Toast.makeText(this, messageBox.getText().toString(),Toast.LENGTH_SHORT).show();
        editor.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
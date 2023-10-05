package com.mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView message_label_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent actIntent = getIntent();
        String message = actIntent.getStringExtra("sms");
        message_label_tv = findViewById(R.id.message_label_TV);
        message_label_tv.setText(message);

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED){
            String[] permission = new String[]{Manifest.permission.RECEIVE_SMS};
            ActivityCompat.requestPermissions(this, permission, 101);

        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String message = intent.getStringExtra("sms");
        message_label_tv = findViewById(R.id.message_label_TV);
        message_label_tv.setText(message);
    }
}

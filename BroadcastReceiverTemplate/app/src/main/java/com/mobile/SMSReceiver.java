package com.mobile;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {

            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                String format = bundle .getString("format").toString();

                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i], format);
                    String sender = currentMessage.getDisplayOriginatingAddress();
                    //getMessageBody = the message itself
                    String message = currentMessage.getMessageBody();
                    String printMessage = "Sender: " + sender + "\nMessage: " + message;
                    Log.i("SMS", printMessage);
                    Toast.makeText(context, printMessage, Toast.LENGTH_LONG).show();

                    Intent actIntent = new Intent(context, MainActivity.class);
                    actIntent.putExtra("sms", message);
                    actIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(actIntent);
                }
            }
            //Log.i("SMSReceived", "received sms");

        }
    }
}

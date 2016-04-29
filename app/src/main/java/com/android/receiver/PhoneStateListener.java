package com.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Anoop on 29-04-2016.
 */
public class PhoneStateListener extends BroadcastReceiver {

    public static String TAG="PhoneStateListener";

    public static String ACTION_PHONE_STATE = "android.intent.action.PHONE_STATE";
    public static String ACTION_OUTGOING_CALL = "android.intent.action.NEW_OUTGOING_CALL";
    public static String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(ACTION_PHONE_STATE)) {

            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {

                Toast.makeText(context, "Incoming call", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Incoming call");
            }

        } else if (intent.getAction().equals(ACTION_OUTGOING_CALL)) {
            Toast.makeText(context, "Outgoing call", Toast.LENGTH_SHORT).show();

            Log.d(TAG, "Outgoing call");
        } else if (intent.getAction().equals(ACTION_SMS_RECEIVED)) {

            Toast.makeText(context, "Incoming message", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Incoming message");
        }

    }
}

package com.example.joggingbuddy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReminderReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Show a reminder notification or Toast
        Toast.makeText(context, "Time for jogging!", Toast.LENGTH_LONG).show();
    }
}

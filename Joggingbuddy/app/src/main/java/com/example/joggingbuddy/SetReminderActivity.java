package com.example.joggingbuddy;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SetReminderActivity extends AppCompatActivity {

    EditText etReminderTime;
    Button btnSetReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_reminder);

        etReminderTime = findViewById(R.id.etReminderTime);
        btnSetReminder = findViewById(R.id.btnSetReminder);

        btnSetReminder.setOnClickListener(v -> {
            String reminderTime = etReminderTime.getText().toString();

            if (!reminderTime.isEmpty()) {
                // For simplicity, assume the reminder time is given in hours
                int hour = Integer.parseInt(reminderTime.split(":")[0]);
                int minute = Integer.parseInt(reminderTime.split(":")[1]);

                // Set the alarm here
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                Intent intent = new Intent(SetReminderActivity.this, ReminderReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(SetReminderActivity.this, 0, intent, 0);

                alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                Toast.makeText(SetReminderActivity.this, "Reminder Set", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SetReminderActivity.this, "Please enter a time", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


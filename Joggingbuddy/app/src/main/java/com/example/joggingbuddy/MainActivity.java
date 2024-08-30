package com.example.joggingbuddy;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCreateGroup, btnSetActivities, btnSetReminder, btnSetStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateGroup = findViewById(R.id.btnCreateGroup);
        btnSetActivities = findViewById(R.id.btnSetActivities);
        btnSetReminder = findViewById(R.id.btnSetReminder);
        btnSetStatus = findViewById(R.id.btnSetStatus);

        btnCreateGroup.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CreateGroupActivity.class);
            startActivity(intent);
        });

        btnSetActivities.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SetActivitiesActivity.class);
            startActivity(intent);
        });

        btnSetReminder.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SetReminderActivity.class);
            startActivity(intent);
        });

        btnSetStatus.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SetStatusActivity.class);
            startActivity(intent);
        });
    }
}

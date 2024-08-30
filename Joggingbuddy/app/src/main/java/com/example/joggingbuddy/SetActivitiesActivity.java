package com.example.joggingbuddy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SetActivitiesActivity extends AppCompatActivity {

    EditText etJoggingTime, etOtherActivity;
    Button btnSetActivities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_activities);

        etJoggingTime = findViewById(R.id.etJoggingTime);
        etOtherActivity = findViewById(R.id.etOtherActivity);
        btnSetActivities = findViewById(R.id.btnSetActivities);

        btnSetActivities.setOnClickListener(v -> {
            String joggingTime = etJoggingTime.getText().toString();
            String otherActivity = etOtherActivity.getText().toString();

            if (!joggingTime.isEmpty() || !otherActivity.isEmpty()) {
                // Save the activities (e.g., to a database or SharedPreferences)
                Toast.makeText(SetActivitiesActivity.this, "Activities Set", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SetActivitiesActivity.this, "Please enter at least one activity", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

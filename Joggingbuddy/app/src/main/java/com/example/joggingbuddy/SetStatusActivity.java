package com.example.joggingbuddy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SetStatusActivity extends AppCompatActivity {

    EditText etGroupStatus;
    Button btnSetStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_status);

        etGroupStatus = findViewById(R.id.etGroupStatus);
        btnSetStatus = findViewById(R.id.btnSetStatus);

        btnSetStatus.setOnClickListener(v -> {
            String status = etGroupStatus.getText().toString();

            if (!status.isEmpty()) {
                // Save the status (e.g., to a database or SharedPreferences)
                Toast.makeText(SetStatusActivity.this, "Status Set", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SetStatusActivity.this, "Please enter a status", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


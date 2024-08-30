package com.example.joggingbuddy;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CreateGroupActivity extends AppCompatActivity {

    EditText etGroupName, etMemberName, etMemberNumber;
    Button btnAddMember, btnSaveGroup;
    ListView lvMembers;

    ArrayList<String> memberList;
    ArrayAdapter<String> memberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        etGroupName = findViewById(R.id.etGroupName);
        etMemberName = findViewById(R.id.etMemberName);
        etMemberNumber = findViewById(R.id.etMemberNumber);
        btnAddMember = findViewById(R.id.btnAddMember);
        btnSaveGroup = findViewById(R.id.btnSaveGroup);
        lvMembers = findViewById(R.id.lvMembers);

        memberList = new ArrayList<>();
        memberAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, memberList);
        lvMembers.setAdapter(memberAdapter);

        btnAddMember.setOnClickListener(v -> {
            String memberName = etMemberName.getText().toString();
            String memberNumber = etMemberNumber.getText().toString();

            if (!memberName.isEmpty() && !memberNumber.isEmpty()) {
                memberList.add(memberName + " - " + memberNumber);
                memberAdapter.notifyDataSetChanged();
                etMemberName.setText("");
                etMemberNumber.setText("");
                Toast.makeText(CreateGroupActivity.this, "Member Added", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(CreateGroupActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
            }
        });

        btnSaveGroup.setOnClickListener(v -> {
            String groupName = etGroupName.getText().toString();
            if (!groupName.isEmpty() && !memberList.isEmpty()) {
                // Save the group information (e.g., to a database or SharedPreferences)
                Toast.makeText(CreateGroupActivity.this, "Group Saved", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(CreateGroupActivity.this, "Please enter group name and add members", Toast.LENGTH_SHORT).show();
            }
        });
    }
}



package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button editTextButton;
    TextView titleEdit;
    String value;
    private SharedPreferences prefs;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        editTextButton = findViewById(R.id.changeTitle);
        titleEdit = findViewById(R.id.editThisText);

        titleEdit.setText("Edit this title");

        editTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        prefs = getSharedPreferences("test", MODE_PRIVATE);
        titleEdit.setText(prefs.getString("value", "Change this Text!"));
    }
}

package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    Button mainAction;
    EditText editText;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editPrefs;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainAction = findViewById(R.id.mainAction);
        editText = findViewById(R.id.editText);

        mainAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = editText.getText().toString().trim();
                prefs = getSharedPreferences("test", MODE_PRIVATE);
                editPrefs = prefs.edit();
                editPrefs.putString("value", value);
                editPrefs.apply();
                finish();
            }
        });
    }



}

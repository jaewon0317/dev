package com.example.intentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Second extends AppCompatActivity {

    Button btnsecond;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnsecond.findViewById(R.id.btnsecond);
        text = findViewById(R.id.text);

        Intent secondIntent = getIntent();
        String readname = secondIntent.getStringExtra("name");
        int year = secondIntent.getIntExtra("age",0);
        year = 2024 - year + 1;
        //text.setText(" "+readname+"age:"+"age");
    }
}
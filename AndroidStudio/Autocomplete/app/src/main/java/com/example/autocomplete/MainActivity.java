package com.example.autocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView singleauto;
    MultiAutoCompleteTextView multiauto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singleauto = findViewById(R.id.singleauto);
        multiauto = findViewById(R.id.multiauto);
        String[] str = new String[]{"shingu-professinoal","shingu_student","shingu-cafe",
                "friday","friend","alpha","ufc"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,str);
        singleauto.setAdapter(adapter);
        MultiAutoCompleteTextView.CommaTokenizer token =
                new MultiAutoCompleteTextView.CommaTokenizer();
        multiauto.setTokenizer(token);
        multiauto.setAdapter(adapter);
    }
}
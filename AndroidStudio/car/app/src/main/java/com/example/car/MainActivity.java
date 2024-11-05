package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText carno,day;
TextView text;
Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carno = findViewById(R.id.carno);
        text = findViewById(R.id.text);
        click = findViewById(R.id.click);
        day = findViewById(R.id.day);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String su1 = carno.getText().toString();
                String su2 = day.getText().toString();

                int today = Integer.parseInt(su2) % 10;
                int temp = Integer.parseInt(su1) % 10;

                if(temp == today)
                    text.setText("오늘은 입고차량이 아닙니다.");
                else
                    text.setText("입고차량입니다.");
            }
        });
    }
}
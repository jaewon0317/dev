package com.example.reservation2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button btnStart,btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calendar;
    TimePicker TimePicker;
    TextView tvYear,tvMonth,tvDay,tvHour,tvMinute;
    int sYear,sMonth,sDay,sHour,sMin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btnStart);
        btnEnd = findViewById(R.id.btnEnd);
        rdoCal = findViewById(R.id.rdoCal);
        rdoTime = findViewById(R.id.rdoTime);
        calendar = findViewById(R.id.calendar);
        TimePicker = findViewById(R.id.TimePicker);
        tvYear = findViewById(R.id.tvYear);
        tvMonth = findViewById(R.id.tvMonth);
        tvDay = findViewById(R.id.tvDay);
        tvHour = findViewById(R.id.tvHour);
        tvMinute = findViewById(R.id.tvMinute);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });//이벤트 리스너 종료
        rdoCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.VISIBLE);
                TimePicker.setVisibility(View.INVISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.setVisibility(View.INVISIBLE);
                TimePicker.setVisibility(View.VISIBLE);
            }
        });
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int iyear, int i1month, int i2day) {
                sYear= iyear;
                sMonth = i1month +1;
                sDay = i2day;

            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLUE);
                tvYear.setText(Integer.toString(sYear));
                tvMonth.setText(Integer.toString(sMonth));
                tvDay.setText(Integer.toString(sDay));
                tvHour.setText(Integer.toString(TimePicker.getCurrentHour()));
                tvMinute.setText(Integer.toString(TimePicker.getCurrentMinute()));
            }
        });

        }
    }

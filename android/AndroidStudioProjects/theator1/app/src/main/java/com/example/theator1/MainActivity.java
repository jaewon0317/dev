package com.example.theator1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

EditText seatno;
Button click;
TextView text;
TextView[] seats = new TextView[10];
Integer[] seatIds = {R.id.s0,R.id.s1,R.id.s2,R.id.s3,R.id.s4,R.id.s5,R.id.s6,R.id.s7,R.id.s8,R.id.s9};
int seatState[] = new int[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seatno = findViewById(R.id.seatno);
        click = findViewById(R.id.click);
        for(int i =0;i<seats.length;i++){
            seats[i]=findViewById(seatIds[i]);
            seatState[i]=0;
        }
        text = findViewById(R.id.text);
        click.setOnClickListener(new View.OnClickListener() {//이번트리스너처리
            @Override
            public void onClick(View view) {
                Integer num = Integer.parseInt(seatno.getText().toString());

                if(seatState[num-1]==0){
                    seats[num-1].setText("X");
                    seatState[num-1]=1;

                    seatno.setText("");
                    seats[num-1].setBackgroundColor(Color.RED);
                    text.setText(num + "번호 자석 예약완료");

                }else{
                    text.setText("예약좌석입니다. 다른 좌석을 선택 바랍니다");
                }


            }
        });

    }
}
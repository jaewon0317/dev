package com.example.theator2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText seatrow,seatcol;
    Button click;
    TextView text;
    TextView[][] seats = new TextView[3][10];
    Integer seatsIds[][] = {{R.id.s00,R.id.s01,R.id.s02,R.id.s03,R.id.s04,R.id.s05,R.id.s06,R.id.s07,R.id.s08,R.id.s09},
                            {R.id.s10,R.id.s11,R.id.s12,R.id.s13,R.id.s14,R.id.s15,R.id.s16,R.id.s17,R.id.s18,R.id.s19},
                            {R.id.s20,R.id.s21,R.id.s22,R.id.s23,R.id.s24,R.id.s25,R.id.s26,R.id.s27,R.id.s28,R.id.s29}};
    int state[][] = new int[3][10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seatcol = findViewById(R.id.seatcol);
        seatrow = findViewById(R.id.seatrow);
        click = findViewById(R.id.click);
        text = findViewById(R.id.text);
        for(int i =0;i<3;i++){
            for(int j =0;j<10;j++){
                seats[i][j] = findViewById(seatsIds[i][j]);
                state[i][j] = 0;//예약 여부 판단하기 위해 필요
            }
        }

        click.setOnClickListener(new View.OnClickListener() {//이번트리스너처리
            @Override
            public void onClick(View view) {
                //1.행과 열을 입력수 받아오기
                Integer rownum = Integer.parseInt(seatrow.getText().toString()); // 행 받아오기
                Integer colnum = Integer.parseInt(seatcol.getText().toString()); // 열 받아오기
//                //2.선택한 의자의 배경색 바꾸기
//                seats[rownum-1][colnum-1].setBackgroundColor(Color.RED);
//                //3.X 표시
//                seats[rownum-1][colnum-1].setText("X");
//                //4.예약 완료 알림
//                text.setText(rownum +"행"+ colnum +"열 좌석 예약됨.");
//                //5.판단 예약 여부

                if(state[rownum-1][colnum-1]==0){
                    //2.선택한 의자의 배경색 바꾸기
                    seats[rownum-1][colnum-1].setBackgroundColor(Color.RED);
                    //3.X 표시
                    seats[rownum-1][colnum-1].setText("X");
                    state[rownum-1][colnum-1]=1;
                    seatrow.setText("");
                    seatcol.setText("");

                    text.setText(rownum +"행"+ colnum +"열 좌석 예약완료.");
                }else{
                    text.setText("예약좌석입니다. 다른 좌석을 선택 바랍니다");
                }

            }
        });//이벤트 리스너 끝

    }
}
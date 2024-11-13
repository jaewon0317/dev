package com.example.dialog2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //대화상자 만들기
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                //대화상자 타이틀 만들기
                dlg.setTitle("좋아하는 간식");
                //배열 생성
                String[] food =new String[]{"딸기","라면","치킨"};
                //아이콘 추가
                dlg.setIcon(R.mipmap.ic_launcher);
                //
                dlg.setItems(food, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btn.setText(food[i]);
                    }
                });
                dlg.show();


            }
        });
    }
}
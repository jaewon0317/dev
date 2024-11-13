package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
LinearLayout linear;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linear = findViewById(R.id.linear);
        button = findViewById(R.id.button);
    }//onCreate 메소드
    //추가 메소드 옵션 메뉴 나타내기

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);//아버지 생성자를 불러서 아버지에 있는 생성자 메소드 불러오기
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.menu1,menu);
        return true;
    }


    //추가메소드 옵션 기능 실행할 소스

}//class
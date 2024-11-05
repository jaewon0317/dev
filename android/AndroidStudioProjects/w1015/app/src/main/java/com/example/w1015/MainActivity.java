package com.example.w1015;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String num1,num2;
    EditText edtnum1,edtnum2;
    TextView text;
    Button add,sub,mul,div;
    Button[] btns = new Button[10];
    Integer[] btnids= {R.id.num0,R.id.num1,R.id.num2,R.id.num3,R.id.num4,R.id.num5,R.id.num6,R.id.num7,R.id.num8,R.id.num9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<10;i++)
            btns[i] = findViewById(btnids[i]);

        edtnum1 = findViewById(R.id.edtnum1);
        edtnum2 = findViewById(R.id.edtnum2);
        text = findViewById(R.id.text);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int su1 = Integer.parseInt(edtnum1.getText().toString());
                int su2 = Integer.parseInt(edtnum2.getText().toString());
                int result = su1 + su2;
                text.setText(""+result);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int su1 = Integer.parseInt(edtnum1.getText().toString());
                int su2 = Integer.parseInt(edtnum2.getText().toString());
                int result = su1 - su2;
                text.setText(""+result);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int su1 = Integer.parseInt(edtnum1.getText().toString());
                int su2 = Integer.parseInt(edtnum2.getText().toString());
                int result = su1 * su2;
                text.setText(""+result);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int su1 = Integer.parseInt(edtnum1.getText().toString());
                int su2 = Integer.parseInt(edtnum2.getText().toString());
                int result = su1 / su2;
                text.setText("result:"+result);
            }
        });
        for(int i =0;i<10;i++){
            final int index = i;
            btns[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edtnum1.isFocused()==true){//focused 시험이래용
                        num1 = edtnum1.getText().toString() + btns[index].getText().toString();
                        edtnum1.setText(num1);
                    }else if(edtnum2.isFocused()==true) {
                        num2 = edtnum2.getText().toString() + btns[index].getText().toString();
                        edtnum2.setText(num2);
                    }//else
                }//onclick
            });//이벤트리스너
        }//for
    }//oncreate
}//클래스

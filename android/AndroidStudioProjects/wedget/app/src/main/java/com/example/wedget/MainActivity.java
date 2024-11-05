package com.example.wedget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2;
    Button add,sub,mul,div;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        text = findViewById(R.id.text);
        //이벤트 리스너 작업이다.
//        text1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                text1.setText("나 눌렀음?");
//            }
//        });
    }//oncreate
}//class

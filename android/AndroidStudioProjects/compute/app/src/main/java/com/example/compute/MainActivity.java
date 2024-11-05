package com.example.compute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edtno1,edtno2;
Button btnadd,btnsub,btnmul,btndiv;
TextView text;
String su1,su2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtno1 = findViewById(R.id.edtno1);
        edtno2 = findViewById(R.id.edtno2);
        btnadd = findViewById(R.id.btnadd);
        btnsub = findViewById(R.id.btnsub);
        btnmul = findViewById(R.id.btnmul);
        btndiv = findViewById(R.id.btndiv);
        text = findViewById(R.id.text);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //로직을 완성하시오
            su1 = edtno1.getText().toString();
            su2 = edtno2.getText().toString();
            int value = Integer.parseInt(su1) + Integer.parseInt(su2);
            text.setText("value:"+value);
            }
        });//이벤트리스너 end
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로직을 완성하시오
                su1 = edtno1.getText().toString();
                su2 = edtno2.getText().toString();
                int value = Integer.parseInt(su1) - Integer.parseInt(su2);
                text.setText("value:"+value);
            }
        });//이벤트리스너 end
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로직을 완성하시오
                su1 = edtno1.getText().toString();
                su2 = edtno2.getText().toString();
                int value = Integer.parseInt(su1) * Integer.parseInt(su2);
                text.setText("value:"+value);
            }
        });//이벤트리스너 end
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //로직을 완성하시오
                su1 = edtno1.getText().toString();
                su2 = edtno2.getText().toString();
                int value = Integer.parseInt(su1) / Integer.parseInt(su2);
                text.setText("value:"+value);
            }
        });//이벤트리스너 end
    }//onCreate end

}//class end
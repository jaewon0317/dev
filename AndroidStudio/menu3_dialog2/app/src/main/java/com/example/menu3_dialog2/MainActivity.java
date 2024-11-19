package com.example.menu3_dialog2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText  edtname,edthp;
    TextView tvname,tvhp;
    Button click,input;
    View dialog1,toast1; // 대화상자 view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvname = findViewById(R.id.tvname);
        tvhp = findViewById(R.id.tvhp);
        input = findViewById(R.id.input);

//        edtname = findViewById(R.id.edtname);
//        edthp = findViewById(R.id.edthp);
//        click = findViewById(R.id.click);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //대화상자뷰 내액티비티로 불러오기
                dialog1 = view.inflate(MainActivity.this,R.layout.dialog1,null);

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보입력창");
                dlg.setView(dialog1);
                dlg.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        edtname = dialog1.findViewById(R.id.edtname);
                        edthp = dialog1.findViewById(R.id.edthp);
                        tvname.setText(edtname.getText().toString());
                        tvname.setBackgroundColor(Color.LTGRAY);
                        tvhp.setBackgroundColor(Color.CYAN);
                    }
                });
                dlg.setPositiveButton("cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = new Toast(getApplicationContext());
                        toast1= View.inflate(MainActivity.this,
                                R.layout.toast1,null);
                        toast.setView();
                        toast.show();
                    }
                });

                dlg.show();
            }
        });

    }
}
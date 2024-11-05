package com.example.radioimg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox check;
    RadioGroup rgroup;
    RadioButton rdog,rcat,rbird;
    Button click;
    TextView text;
    ImageView img;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = findViewById(R.id.check);
        text = findViewById(R.id.text);
        rgroup = findViewById(R.id.rgroup);
        rdog = findViewById(R.id.rdog);
        rcat = findViewById(R.id.rbird);
        click = findViewById(R.id.click);
        img = findViewById(R.id.img);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(check.isChecked()==true){
                    text.setVisibility(View.VISIBLE);
                    rgroup.setVisibility(View.VISIBLE);
                    click.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }else{
                    text.setVisibility(View.INVISIBLE);
                    rgroup.setVisibility(View.INVISIBLE);
                    click.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });//check 이벤트
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int res = rgroup.getCheckedRadioButtonId();
                if(res == R.id.rdog)
                    img.setImageResource(R.drawable.dog);
                else if(res == R.id.rcat)
                    img.setImageResource(R.drawable.cat);
                else if(res == R.id.rbird)
                    img.setImageResource(R.drawable.bird);
            }
        });
    }
}
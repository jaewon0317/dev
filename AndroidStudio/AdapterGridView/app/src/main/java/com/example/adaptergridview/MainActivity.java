package com.example.adaptergridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    Context context;
    Integer postid[] = {R.drawable.mov01, R.drawable.mov02,
            R.drawable.mov03, R.drawable.mov04,
            R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08,
            R.drawable.mov09, R.drawable.mov10,
            R.drawable.mov11, R.drawable.mov12,
            R.drawable.mov13, R.drawable.mov14,
            R.drawable.mov15, R.drawable.mov16,
            R.drawable.mov17, R.drawable.mov18,
            R.drawable.mov19, R.drawable.mov20,
            R.drawable.mov21, R.drawable.mov22,
            R.drawable.mov23, R.drawable.mov24};

    public GridAdapter(Context context){
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = findViewById(R.id.grid);
        GridAdapter adapter = new GridAdapter(MainActivity.this);
        grid.setAdapter(adapter);
    }

        public GridAdapter extends  BaseAdapter {
            this.context = context;
        }
        public View getView ( int pos, View view, ViewGroup viewGroup) {
            ImageView img = new ImageView(context);
            img.setLayoutParams(new ViewGroup.LayoutParams(150, 200));
            img.setPadding(5, 5, 5, 5);
            img.setImageResource(postid[pos]);
            final int index = pos;
        }
        public void onClick(View view){
            //대화 상자
            dialog = View.inflate(MainActivity.this,R.layout.dialog,null);
            ImageView ivPoster = dialog.findViewById(R.id.ivPoster);
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setView(dialog);
            dlg.setTitle("big img");
            dlg.setIcon(R.drawable.movie_icon);
            ivPoster.setImageResource(postid[pos]);
            dlg.setPositiveButton("closed",null);

            dlg.show();
        }
        public int getCount () {
            return postid.length;
        }
}
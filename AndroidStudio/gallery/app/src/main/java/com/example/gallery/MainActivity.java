package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
Gallery gallery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = findViewById(R.id.gallery);
        GalleryAdapter adapter = new GalleryAdapter(MainActivity.)
    }
    public class GalleryAdapter extends BaseAdapter {
        Context context;
        Integer postid[] = {
                R.drawable.mov01, R.drawable.mov02,
                R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06,
                R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov11, R.drawable.mov12,
                R.drawable.mov13, R.drawable.mov14
        };
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView img = new ImageView(MainActivity.this);
            img.setLayoutParams(new ViewGroup.LayoutParams(200,300));
            img.setScaleType(ImageView.ScaleType.CENTER);
            img.setPadding(5,5,5,5);
            img.setImageResource(postid[i]);
            img.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    img.setImageResource();
                    return false;
                }
            });
        }

        @Override
        public int getCount() {
            return postid.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

    }
}

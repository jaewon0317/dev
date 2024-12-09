package com.example.tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    TabHost tabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = findViewById(R.id.tabhost);
        TabHost.setup();

        TabHost.TapSpec tabspec1 = tabHost.newTabspec("song");
        tabspec1.setIndicator("song");
        tabspec1.setContent(R.id.song);
        tabHost.addTab(tapspec1);

        TabHost.TapSpec tabspec2 = tabHost.newTabspec("artist");
        tabspec1.setIndicator("artist");
        tabspec1.setContent(R.id.artist);
        tabHost.addTab(tapspec2);

        TabHost.TapSpec tabspec3 = tabHost.newTabspec("album");
        tabspec1.setIndicator("album");
        tabspec1.setContent(R.id.album);
        tabHost.addTab(tapspec3);



    }
}
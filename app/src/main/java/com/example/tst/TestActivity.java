package com.example.tst;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_test);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.d("CXT", "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("CXT", "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("CXT", "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("CXT", "onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d("CXT", "onRestart");
        super.onRestart();
    }
}

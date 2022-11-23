package com.example.a20221121_michaelcasalinuovo_nycschools.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.a20221121_michaelcasalinuovo_nycschools.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        handler.postDelayed((Runnable) () -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}
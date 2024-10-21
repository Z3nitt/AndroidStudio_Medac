package com.example.sexo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import androidx.appcompat.app.AppCompatActivity;


public class SplashS extends AppCompatActivity {

    public static int TiempoCarga = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_s);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashS.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, TiempoCarga);
    }
}
package com.example.multiapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Vibrar extends AppCompatActivity {
Button btnvibrar, btnvolver;
Vibrator vibrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrar);
        btnvibrar = (Button) findViewById(R.id.btnvibrar);
        vibrar = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        btnvolver = (Button) findViewById(R.id.btnvolver);

        btnvibrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrar.vibrate(800);
            }
        });

        btnvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Vibrar.this, MainActivity.class);
                startActivity(volver);
            }
        });
    }
}
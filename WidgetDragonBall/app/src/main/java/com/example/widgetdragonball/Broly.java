package com.example.widgetdragonball;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Broly extends AppCompatActivity {
Button b1;
Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broly);
        b1 = (Button) findViewById(R.id.buttonvolver);
        b2 = (Button) findViewById(R.id.sonido);
        ImageView gifbroly = findViewById(R.id.brolyGIF);
        MediaPlayer mp =MediaPlayer.create(Broly.this, R.raw.audiobroly);
        Glide.with(this)
                .asGif()
                .load(R.drawable.brolygif)
                .into(gifbroly);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                Intent intent = new Intent(Broly.this, MainActivity.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });
    }
}
package com.example.sexo;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button b;
Button b2;
Button b3;
ImageView img;
ConstraintLayout cl;
Switch sw;
TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        img = (ImageView) findViewById(R.id.imageView);
        cl = (ConstraintLayout) findViewById(R.id.main);
        sw = (Switch) findViewById(R.id.switch1);
        tv = (TextView) findViewById(R.id.textView);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(R.mipmap.si);
                MediaPlayer mp =MediaPlayer.create(MainActivity.this, R.raw.music);
                mp.start();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(R.mipmap.no);
                MediaPlayer mp =MediaPlayer.create(MainActivity.this, R.raw.music);
                mp.start();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(R.mipmap.pregunta);
                MediaPlayer mp =MediaPlayer.create(MainActivity.this, R.raw.music);
                mp.start();
            }
        });
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (sw.isChecked()){
                    cl.setBackgroundResource(R.color.black);
                    tv.setTextColor(getResources().getColor(R.color.white));
                    sw.setTextColor(getResources().getColor(R.color.white));
                }
                else{
                    cl.setBackgroundResource(R.color.white);
                    sw.setTextColor(getResources().getColor(R.color.black));
                    tv.setTextColor(getResources().getColor(R.color.black));
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
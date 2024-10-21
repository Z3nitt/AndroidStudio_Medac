package com.example.widgetdragonball;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Goku extends AppCompatActivity {

Button b1;
Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goku);
        b1 = (Button) findViewById(R.id.buttonvolver);
        b2 = (Button) findViewById(R.id.sonido);
        //Inizializo el ImageView
        ImageView gifgoku = findViewById(R.id.gokuGIF);
        MediaPlayer mp =MediaPlayer.create(Goku.this, R.raw.audiogoku);
        //Libreria para cargar gif
        //Glide.with(this): Inicializa Glide con el contexto de la actividad.
        //asGif(): Indica que el archivo a cargar es un GIF.
        //load(R.drawable.your_gif_file): Aquí deberás reemplazar your_gif_file por el nombre del archivo GIF que hayas colocado en la carpeta res/drawable
        //into(gifImageView): Carga el GIF en el ImageView que definiste en tu layout.

        Glide.with(this)
                .asGif()
                .load(R.drawable.gokugif)
                .into(gifgoku);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                Intent intent = new Intent(Goku.this, MainActivity.class);
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
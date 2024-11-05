package com.example.ejemplolistview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PersonajeClick extends AppCompatActivity {
    private Button btnatras, btnvideo, btncoords, btntlf, btnweb;
    private ImageView ivfoto;
    private TextView txtnombre,txtdesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_click);

        btnatras = (Button) findViewById(R.id.btnatras);
        ivfoto = (ImageView) findViewById(R.id.foto);
        txtnombre = (TextView) findViewById(R.id.nombre);
        txtdesc = (TextView) findViewById(R.id.desc);
        btnvideo = (Button) findViewById(R.id.btnvideo);
        btncoords = (Button) findViewById(R.id.btncoords);
        btntlf = (Button) findViewById(R.id.btntlf);
        btnweb = (Button) findViewById(R.id.btnweb);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String descExtendida = intent.getStringExtra("descExtendida");
        int imagenId = intent.getIntExtra("imagenId", -1);

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intentweb);

            }
        });

        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentvideo = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                startActivity(intentvideo);
            }
        });

        btncoords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcoords = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain View, CA"));
                startActivity(intentcoords);
            }
        });

        btntlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenttlf = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456789"));
                startActivity(intenttlf);
            }
        });



        txtnombre.setText(nombre);
        txtdesc.setText(descExtendida);
        ivfoto.setImageResource(imagenId);

        btnatras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
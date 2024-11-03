package com.example.ejemplolistview;

import android.content.Intent;
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
    private Button btnatras;
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

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("nombre");
        String descExtendida = intent.getStringExtra("descExtendida");
        int imagenId = intent.getIntExtra("imagenId", -1);

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
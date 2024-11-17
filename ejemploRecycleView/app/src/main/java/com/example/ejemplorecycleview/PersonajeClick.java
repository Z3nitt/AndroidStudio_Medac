package com.example.ejemplorecycleview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PersonajeClick extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje_click);

        TextView nombrePersonaje = findViewById(R.id.nombrePersonajeDetalle);
        ImageView imagenPersonaje = findViewById(R.id.imagenPersonajeDetalle);
        TextView descripcionExtendida = findViewById(R.id.descripcionExtendida);
        Button botonVolver = findViewById(R.id.botonVolver);

        // Obtener los datos de Intent
        String nombre = getIntent().getStringExtra("nombre");
        int imagenID = getIntent().getIntExtra("imagenID", 0);
        String descripcion = getIntent().getStringExtra("descripcionExtendida");

        // Configurar los elementos de la vista
        nombrePersonaje.setText(nombre);
        imagenPersonaje.setImageResource(imagenID);
        descripcionExtendida.setText(descripcion);

        botonVolver.setOnClickListener(v -> finish());
    }
}
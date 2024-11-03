package com.example.ejemplolistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    listaDragonball listaDragonball = new listaDragonball();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lista);

        ArrayList<Personaje> nombresDragonball = listaDragonball.getListaDragonBall();

        PersonajeAdapter adapter = new PersonajeAdapter(this, nombresDragonball);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Personaje personajeSelecc = nombresDragonball.get(pos);

                Intent intent = new Intent(MainActivity.this, PersonajeClick.class);

                intent.putExtra("nombre", personajeSelecc.getNombre());
                intent.putExtra("descExtendida", personajeSelecc.getDescExtendida());
                intent.putExtra("imagenId", personajeSelecc.getImagenID());

                startActivity(intent);
            }
        });



    }
}
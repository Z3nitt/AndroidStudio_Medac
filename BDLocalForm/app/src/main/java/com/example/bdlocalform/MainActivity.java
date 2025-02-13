package com.example.bdlocalform;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button btninsertar, btnmostrar;
TextView txtnombre, txtapellidos, txttelefono, txtemail, txtdireccion;
EditText edtnombre, edtapellidos, edttelefono, edtemail, edtdireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btninsertar = findViewById(R.id.button);
        btnmostrar = findViewById(R.id.button2);

        txtnombre = findViewById(R.id.textView);
        txtapellidos = findViewById(R.id.textView2);
        txttelefono = findViewById(R.id.textView3);
        txtemail = findViewById(R.id.textView4);
        txtdireccion = findViewById(R.id.textView5);

        edtnombre = findViewById(R.id.editTextText);
        edtapellidos = findViewById(R.id.editTextText2);
        edttelefono = findViewById(R.id.editTextText3);
        edtemail = findViewById(R.id.editTextText4);
        edtdireccion = findViewById(R.id.editTextText5);

        btninsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                if (edtnombre.getText().toString().isEmpty() ||
                        edtapellidos.getText().toString().isEmpty() ||
                        edttelefono.getText().toString().isEmpty() ||
                        edtemail.getText().toString().isEmpty() ||
                        edtdireccion.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Hay uno o mas campos vacios", Toast.LENGTH_SHORT).show();
                }
                else{

                    dbHelper.insertar(edtnombre.getText().toString(),
                            edtapellidos.getText().toString(),
                            edttelefono.getText().toString(),
                            edtemail.getText().toString(),
                            edtdireccion.getText().toString(),
                            db);
                    if (db!=null){
                        Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Error al crear la base de datos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Mostrar.class);
                startActivity(intent);
            }
        });
    }
}
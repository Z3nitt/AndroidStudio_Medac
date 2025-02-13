package com.example.appbbdd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
Button btnBBDD;
TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBBDD = findViewById(R.id.btnBBDD);
        tv1 = findViewById(R.id.tv1);

        btnBBDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String texto = "";

                dbHelper.insertar("Antonio", "0001", "antonio@gmail.com", db);
                dbHelper.insertar("Luis", "0002", "luis@gmail.com", db);

                if (db!=null){
                    Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_SHORT).show();
                    Cursor cursor = db.rawQuery("SELECT * FROM t_contactos", null);

                    while (cursor.moveToNext()){
                        int id = cursor.getInt(0);
                        String name = cursor.getString(1);
                        String telefono = cursor.getString(2);
                        String email = cursor.getString(3);

                        texto = texto + "id: "+ id+ ", Name: "+ name + ", Telefono: " + telefono + ", Email: "+email;
                    }
                    tv1.setText(texto);
                    cursor.close();
                }
                else {
                    Toast.makeText(MainActivity.this, "Error al crear la base de datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        dbHelper.borrarDatos(db); // Borra todos los registros al cerrar la actividad
        dbHelper.close(db);
    }

}
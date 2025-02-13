package com.example.bdlocalform;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.database.Cursor;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Mostrar extends AppCompatActivity {
TextView textView6, textView7, textView8, textView9, textView10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        DbHelper dbHelper = new DbHelper(Mostrar.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String texto1 = "";
        String texto2 = "";
        String texto3 = "";
        String texto4 = "";
        String texto5 = "";

        textView6= findViewById(R.id.textView6);
        textView7= findViewById(R.id.textView7);
        textView8= findViewById(R.id.textView8);
        textView9= findViewById(R.id.textView9);
        textView10= findViewById(R.id.textView10);

        if (db!=null){
            Cursor cursor = db.rawQuery("SELECT * FROM t_form", null);

            while (cursor.moveToNext()){
                String nombre = cursor.getString(0);
                String apellidos = cursor.getString(1);
                String telefono = cursor.getString(2);
                String email = cursor.getString(3);
                String direccion = cursor.getString(4);

                texto1 = texto1 + nombre;
                texto2 = texto2 + apellidos;
                texto3 = texto3 + telefono;
                texto4 = texto4 + email;
                texto5 = texto5 + direccion;
            }
            textView6.setText(texto1);
            textView7.setText(texto2);
            textView8.setText(texto3);
            textView9.setText(texto4);
            textView10.setText(texto5);

            cursor.close();
        }
        else {
            Toast.makeText(Mostrar.this, "Error al abrir la base de datos", Toast.LENGTH_SHORT).show();
        }
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
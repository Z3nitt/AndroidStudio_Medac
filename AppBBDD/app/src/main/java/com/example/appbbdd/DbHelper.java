package com.example.appbbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "agenda.db";
    private static final String TABLE_CONTACTOS="t_contactos";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_CONTACTOS + "(" +"id INTEGER PRIMARY KEY AUTOINCREMENT," +"nombre TEXT NOT NULL," +"telefono TEXT NOT NULL," +"correo_electronico TEXT)");
    }

    public void insertar (String nombre, String telefono, String email, SQLiteDatabase db){
        ContentValues cv1 = new ContentValues();

        cv1.put("nombre", nombre);
        cv1.put("telefono", telefono);
        cv1.put("correo_electronico", email);

        db.insert(TABLE_CONTACTOS, null, cv1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLE_CONTACTOS);
        onCreate(db);

    }

    public void close (SQLiteDatabase db){
        if (db!=null){
            db.close();
        }
    }

    public void borrarDatos(SQLiteDatabase db){
        db.execSQL("DELETE FROM "+ TABLE_CONTACTOS);
    }
}

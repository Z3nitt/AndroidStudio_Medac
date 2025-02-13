package com.example.bdlocalform;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "agenda.db";
    private static final String TABLE_FORM="t_form";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+
                TABLE_FORM +
                "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellidos TEXT NOT NULL," +
                "telefono TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "direccion TEXT NOT NULL)");
    }

    public void insertar(String nombre, String apellidos, String telefono, String email, String direccion, SQLiteDatabase db){
        ContentValues cv1 = new ContentValues();

        cv1.put("nombre", nombre);
        cv1.put("apellidos", apellidos);
        cv1.put("telefono", telefono);
        cv1.put("email", email);
        cv1.put("direccion", direccion);

        db.insert(TABLE_FORM, null, cv1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+TABLE_FORM);
        onCreate(db);
    }

    public void close (SQLiteDatabase db){
        if(db!=null){
            db.close();
        }
    }

    public void borrarDatos(SQLiteDatabase db){
        db.execSQL("DELETE FROM "+ TABLE_FORM);
    }
}

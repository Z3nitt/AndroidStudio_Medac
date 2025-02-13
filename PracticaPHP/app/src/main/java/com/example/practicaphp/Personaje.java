package com.example.practicaphp;

public class Personaje {
    private String Nombre;
    private int Poder;
    private String Descripcion;
    private String Universo;

    public Personaje(String Nombre, int Poder, String Descripcion, String Universo) {
        this.Nombre = Nombre;
        this.Poder = Poder;
        this.Descripcion = Descripcion;
        this.Universo = Universo;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getPoder() {
        return Poder;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getUniverso() {
        return Universo;
    }



}

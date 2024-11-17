package com.example.ejemplorecycleview;

public class Personaje {
    private String nombre;
    private String desc;
    private String descripcionExtendida;  // Asegúrate de incluir esta propiedad
    private int imagenID;

    public Personaje(String nombre, String desc, String descripcionExtendida, int imagenID) {
        this.nombre = nombre;
        this.desc = desc;
        this.descripcionExtendida = descripcionExtendida;
        this.imagenID = imagenID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDesc() {
        return desc;
    }

    public String getDescripcionExtendida() {
        return descripcionExtendida;
    }

    public int getImagenID() {
        return imagenID;
    }
}

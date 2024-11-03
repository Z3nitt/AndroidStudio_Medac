package com.example.ejemplolistview;

public class Personaje {
    private String nombre;
    private String desc;
    private String descExtendida;
    private int imagenID;

    public Personaje(String nombre, String desc, String descExtendida ,int imagenID){
        this.nombre = nombre;
        this.desc = desc;
        this.descExtendida = descExtendida;
        this.imagenID = imagenID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescExtendida() {
        return descExtendida;
    }

    public void setDescExtendida(String descExtendida) {
        this.descExtendida = descExtendida;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImagenID() {
        return imagenID;
    }

    public void setImagenID(int imagenID) {
        this.imagenID = imagenID;
    }
}

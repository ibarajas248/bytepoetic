package com.example.bytepoetic;

public class personaje {
    private String nombre;
    private String info;
    private int foto;
    private String URL_foto;


    public personaje(String nombre, String info, int foto) {
        this.nombre = nombre;
        this.info = info;
        this.foto = foto;
    }
    public personaje(String nombre, String info, String URL_foto) {
        this.nombre = nombre;
        this.info = info;
        this.URL_foto=URL_foto;
    }


    public String getURL_foto() {
        return URL_foto;
    }

    public void setURL_foto(String URL_foto) {
        this.URL_foto = URL_foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

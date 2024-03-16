package com.example.bytepoetic;

public class menuPrincipal {

    private String Titulo;
    private int foto;

    public menuPrincipal(String titulo, int foto) {
        Titulo = titulo;
        this.foto = foto;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

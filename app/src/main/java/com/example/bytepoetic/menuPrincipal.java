package com.example.bytepoetic;

public class menuPrincipal {

    private String Titulo;
    private String foto;

    public menuPrincipal(String titulo, String foto) {
        Titulo = titulo;
        this.foto = foto;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}


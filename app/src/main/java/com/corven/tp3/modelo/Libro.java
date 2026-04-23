package com.corven.tp3.modelo;

public class Libro {
    private String titulo;
    private String autor;
    private String descripcion;
    private String año;
    private int imagen;

    public Libro(String titulo, String autor, String descripcion, String año, int imagen) {
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.año = año;
        this.imagen = imagen;
    }

    public Libro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

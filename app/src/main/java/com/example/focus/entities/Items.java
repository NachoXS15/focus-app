package com.example.focus.entities;

public class Items {
    String Titulo, Descripcion, Fecha;
    public Items(){}

    public Items(String titulo, String descripcion, String fecha) {
        this.Titulo = titulo;
        this.Descripcion = descripcion;
        this.Fecha = fecha;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }
}



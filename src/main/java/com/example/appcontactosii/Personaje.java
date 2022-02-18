package com.example.appcontactosii;


// CLASE PERSONAJE
public class Personaje {
    private int id;
    private String imagen;
    private String nombre;
    private String estado;
    private String especie;
    private String genero;


    public Personaje(int id, String imagen, String nombre, String estado, String especie, String genero) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.estado = estado;
        this.especie = especie;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public String getEspecie() {
        return especie;
    }

    public String getGenero() {
        return genero;
    }
}

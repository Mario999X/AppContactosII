package com.example.appcontactosii;

import javafx.scene.image.Image;

import java.net.URL;

public class Personaje {
    private String imagen;
    private int id;
    private String nombre;
    private String estado;
    private String especie;
    private String genero;


    public Personaje(String imagen, int id, String nombre, String estado, String especie, String genero) {
        this.imagen = imagen;
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.especie = especie;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getImagen() { return imagen; }

    public int getId() {
        return id;
    }

    public String getNombre() { return nombre; }

    public String getEstado() {
        return estado;
    }

    public String getEspecie() { return especie; }

    public String getGenero() { return genero; }
}

package com.example.appcontactosii;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


import java.net.URI;

// CONTROLADOR VISTA ANIDADA
public class AppDetalleController {

    @FXML
    private StackPane appDetalle;
    @FXML
    private ImageView imagenPersonaje;
    @FXML
    private Label nombrePersonaje, estadoPersonaje, especiePersonaje, generoPersonaje;

    // Metodo encargado de volver invisible la vista appDetalle.
    @FXML
    private void volverPrincipal() {
        appDetalle.setVisible(false);
    }

    /* Metodo encargado de cargar los distintos personajes en la vista, cada informacion personal es enlazada a
        un label de la vista.
    En el caso de la imagen, que sera imprimida en un ImageView, es comvertida en una URI, puesto que de la
        API se consigue una direccion (String), y eso no es compatible con Image.
     */
    public void cargarPersona(String imagenUri, String nombre, String estado, String especie, String genero) {
        URI.create(imagenUri);
        Image imagen = new Image(imagenUri);
        imagenPersonaje.setImage(imagen);
        nombrePersonaje.setText(nombre);
        estadoPersonaje.setText(estado);
        especiePersonaje.setText(especie);
        generoPersonaje.setText(genero);
    }

}

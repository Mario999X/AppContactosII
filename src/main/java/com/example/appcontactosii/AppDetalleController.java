package com.example.appcontactosii;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


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
    En el caso de la imagen, que sera imprimida en un ImageView, es convertida en una URI, puesto que de la
        API se consigue una direccion (String), y eso no es compatible con Image.
     */
    public void cargarPersonaje(Personaje personaje) {
        Image imagen = new Image(personaje.getImagen());
        imagenPersonaje.setImage(imagen);
        nombrePersonaje.setText(personaje.getNombre());
        estadoPersonaje.setText(personaje.getEstado());
        especiePersonaje.setText(personaje.getEspecie());
        generoPersonaje.setText(personaje.getGenero());
    }

}

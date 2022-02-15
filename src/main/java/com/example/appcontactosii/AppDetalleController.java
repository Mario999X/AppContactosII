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
    private VBox vBoxCentral, vBoxInfo;
    @FXML
    private Button btnAtras;
    @FXML
    private ImageView imagenPersonaje;
    @FXML
    private Label nombrePersonaje, estadoPersonaje, especiePersonaje, generoPersonaje;

    @FXML
    private void volverPrincipal() {
        appDetalle.setVisible(false);
    }

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

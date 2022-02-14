package com.example.appcontactosii;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;

// CONTROLADOR VISTA ANIDADA
public class AppDetalleController {

    @FXML
    private StackPane appAnidada;
    @FXML
    private VBox vBoxCentral, vBoxInfo;
    @FXML
    private Button btnAtras;
    @FXML
    private ImageView imagenPersonaje;
    @FXML
    private Label idPersonaje, nombrePersonaje, estadoPersonaje, especiePersonaje, generoPersonaje;


    @FXML
    public void initialize() {
        File file = new File("src/main/resources/com/example/appcontactosii/LaAmigaDora.jpg");
        Image image = new Image(file.toURI().toString());
        imagenPersonaje.setImage(image);

    }

    @FXML
    private void volverPrincipal() {
        appAnidada.setVisible(false);
    }

    public void cargarPersona(String imagen, int id, String nombre, String estado, String especie, String genero) {
        idPersonaje.setText(String.valueOf(id));
        nombrePersonaje.setText(nombre);
        estadoPersonaje.setText(estado);
        especiePersonaje.setText(especie);
        generoPersonaje.setText(genero);
    }

}

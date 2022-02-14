package com.example.appcontactosii;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.File;


// CONTROLADOR VISTA ANIDADA
public class AppAnidadaController {

    @FXML private StackPane appAnidada;
    @FXML private VBox vBoxFondo, vBoxCentral, vBoxInfo;
    @FXML private Button btnAtras;
    @FXML private ImageView imagenContacto;
    @FXML private Label idPersonaje, nombrePersonaje, estadoSalud;

    private AppController appController;


    @FXML public void initialize() {
        appController = new AppController();
        appController.getListaDatos();
        File file = new File("src/main/resources/com/example/appcontactosii/LaAmigaDora.jpg");
        Image image = new Image(file.toURI().toString());
        imagenContacto.setImage(image);

    }

    public void cargarPersona(int id, String nombre, String estado){
        idPersonaje.setText(String.valueOf(id));
        nombrePersonaje.setText(nombre);
        estadoSalud.setText(estado);

    }


    @FXML private void volverPrincipal() {
        appAnidada.setVisible(false);
    }
}

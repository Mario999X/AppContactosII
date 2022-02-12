package com.example.appcontactosii;

import javafx.collections.ObservableList;
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

    @FXML private StackPane principalAnidada;
    @FXML private VBox vBoxFondo, vBoxCentral, vBoxInfo;
    @FXML private Button btnAtras;
    @FXML private ImageView imagenContacto;
    @FXML private Label idPersonaje, nombrePersonaje, estadoSalud;

    private Personaje dora = new Personaje(1, "Dora la exploradora", "Viva?");


    @FXML public void initialize() {
        idPersonaje.setText(dora.getNombre());
        nombrePersonaje.setText(String.valueOf(dora.getId()));
        estadoSalud.setText(dora.getEstado());
        File file = new File("src/main/resources/com/example/appcontactosii/LaAmigaDora.jpg");
        Image image = new Image(file.toURI().toString());
        imagenContacto.setImage(image);

    }

    /*
    @FXML
    private void añadirPersona(){}
     */
    @FXML private void volverPrincipal() {
        principalAnidada.setVisible(false);
    }


    public Label getIdPersonaje(ObservableList<Personaje> listaDatos) {
        return idPersonaje;
    }

    public void setIdPersonaje(Label idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public Label getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(Label nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public Label getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(Label estadoSalud) {
        this.estadoSalud = estadoSalud;
    }
}

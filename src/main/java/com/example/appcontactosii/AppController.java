package com.example.appcontactosii;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


// CONTROLADOR VISTA PRINCIPAL
public class AppController implements Initializable {

    private boolean desplegado;

    private TranslateTransition animation, animationBtn;

    @FXML
    private Button btnMenu;
    @FXML
    private VBox vBoxIzquierda;
    @FXML
    private StackPane vistaPrincipal, vistaAnidada, vistaGrafica;
    @FXML
    private ListView <String> listaContactos;

    private AppAnidadaController appAnidadaController;


    public AppController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBoxIzquierda.setTranslateX(-100);
        desplegado = false;
        vistaAnidada.setVisible(false);
        vistaGrafica.setVisible(false);


        ObservableList<String> listaDatos = FXCollections.observableArrayList(
                "C", "Java", "Python", "C++", "C#", "Visual Basic", "JavaScript", "PHP", "R",
                "SQL", "Perl", "Groovy", "Ruby", "Go", "MATLAB", "Swift", "Assembly language",
                "Objective-C", "Classic Visual Basic", "PL/SQL");
        listaContactos.setItems(listaDatos);
        listaContactos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listaContactos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
                System.out.println("Hola: " + newValue);
        });

    }


    @FXML
    private void desplegacion() {
        animation = new TranslateTransition(Duration.millis(300), vBoxIzquierda);
        animationBtn = new TranslateTransition(Duration.millis(300), btnMenu);

        if (!desplegado) {
            animation.setFromX(-vBoxIzquierda.getWidth());
            animation.setToX(0);
            animationBtn.setFromX(0);
            animationBtn.setToX(vBoxIzquierda.getWidth());
            desplegado = true;
        } else {
            animation.setFromX(0);
            animation.setToX(-vBoxIzquierda.getWidth());
            animationBtn.setFromX(vBoxIzquierda.getWidth());
            animationBtn.setToX(0);
            desplegado = false;
        }
        animation.play();
        animationBtn.play();
    }

    @FXML
    private void vistaDetalle(){

        vistaAnidada.setVisible(true);

    }

    @FXML
    private void vistaGrafica(){

        vistaGrafica.setVisible(true);

    }

    @FXML
    private void preferenciasMenu(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Preferencias");
        alert.setContentText("Idiomas disponibles (cambiable en la clase App.java): Español/Inglés");
        alert.showAndWait();
    }

    @FXML
    private void salirApp(){
        System.exit(0);
    }

}


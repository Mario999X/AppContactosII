package com.example.appcontactosii;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
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
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

// CONTROLADOR VISTA PRINCIPAL
public class AppController implements Initializable {
    private boolean desplegado;
    private TranslateTransition animation, animationBtn;

    @FXML
    private Button btnMenu, btnRecarga;
    @FXML
    private VBox vBoxIzquierda;

    @FXML
    private StackPane appPrincipal, appDetalle, appGrafica;
    @FXML
    private ListView<Personaje> listaViewPersonajes;
    private ObservableList<Personaje> listaDatos;
    @FXML
    private AppDetalleController appDetalleController;
    @FXML
    private AppGraficaController appGraficaController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaDatos = FXCollections.observableArrayList();
        vBoxIzquierda.setTranslateX(-100);
        desplegado = false;
        appDetalle.setVisible(false);
        appGrafica.setVisible(false);
        iniciaLista();
        listaViewPersonajes.setItems(listaDatos);
        listaViewPersonajes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listaViewPersonajes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                appDetalleController.cargarPersona(newValue.getImagen(), newValue.getNombre(), newValue.getEstado(),
                        newValue.getEspecie(), newValue.getGenero());
                vistaDetalle();
            }
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
    private void vistaDetalle() {
        appDetalle.setVisible(true);
    }

    @FXML
    private void vistaGrafica() {
        appGrafica.setVisible(true);
        appGraficaController.cargarDatosPieChartGenero(listaDatos);
        appGraficaController.cargarDatosPieChartEspecie(listaDatos);
    }

    @FXML
    private void preferenciasMenu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Preferencias");
        alert.setContentText("Idiomas disponibles (cambiable en la clase App.java): Español/Inglés");
        alert.showAndWait();
    }

    @FXML
    private void salirApp() {
        System.exit(0);
    }

    @FXML
    private void iniciaLista() {
        Runnable task = () -> {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://rickandmortyapi.com/api/character/?page="+Math.random()*29+1))
                    .build();
            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                Platform.runLater(()->listaViewPersonajes.getItems().removeAll(listaDatos));//listaViewPersonajes.getItems().removeAll(listaDatos);
                System.out.println(response.body());
                JSONArray dataArray = new JSONArray(response.body().substring(163,response.body().length()-1));

                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject row = dataArray.getJSONObject(i);
                    Platform.runLater(()->listaDatos.add(new Personaje(row.getString("image"),
                            row.getString("name"),
                            row.getString("status"),
                            row.getString("species"),
                            row.getString("gender"))));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(task).start();
    }

}


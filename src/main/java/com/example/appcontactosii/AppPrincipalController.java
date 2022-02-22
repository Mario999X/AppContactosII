package com.example.appcontactosii;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
public class AppPrincipalController implements Initializable {
    private boolean desplegado;
    private TranslateTransition animation, animationBtn;

    @FXML
    private Button btnMenu;
    @FXML
    private VBox vBoxIzquierda;
    @FXML
    private Label lblNumPagina;
    @FXML
    private StackPane appDetalle, appGrafica, appTabla;
    @FXML
    private ListView<Personaje> listaViewPersonajes;
    private ObservableList<Personaje> listaDatos;
    @FXML
    private AppDetalleController appDetalleController;
    @FXML
    private AppGraficaController appGraficaController;
    @FXML
    private AppTablaController appTablaController;


    // El metodo initialize: se encarga de arrancar las variables, metodos, etc... lo antes posible.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaDatos = FXCollections.observableArrayList();
        vBoxIzquierda.setTranslateX(-100);
        desplegado = false;
        appDetalle.setVisible(false);
        appGrafica.setVisible(false);
        appTabla.setVisible(false);
        iniciaLista();
        listaViewPersonajes.setItems(listaDatos);
        listaViewPersonajes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listaViewPersonajes.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                appDetalleController.cargarPersonaje(newValue);
                vistaDetalle();
            }
        });
    }

    // Metodo encargado de desplegar/ocultar un vBox localizado en la izquierda de la vista.
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

    // Metodo encargado de hacer visible la vista appDetalle.
    @FXML
    private void vistaDetalle() {
        appDetalle.setVisible(true);
    }

    /* Metodo encargado de hacer visible la vista appGrafica.
       En este metodo, hacemos uso de los metodos creados en la appGrafica, pasando la variable
       necesaria; y usando el controlador especifico de esa misma clase.
     */
    @FXML
    private void vistaGrafica() {
        appGrafica.setVisible(true);
        appGraficaController.cargarDatosPieChartGenero(listaDatos);
        appGraficaController.cargarDatosPieChartEspecie(listaDatos);
    }

    /*  Metodo encargado de hacer visible la vista appTabla.
        En este metodo, hacemos uso del metodo creado en la appTabla, pasando la variable
        necesaria; y usando el controlador especifico de esa misma clase.
     */
    @FXML
    private void vistaTabla() {
        appTabla.setVisible(true);
        appTablaController.cargarTabla(listaDatos);
    }

    // Este metodo solo muestra una alerta informativa.
    @FXML
    private void preferenciasMenu() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Preferencias | Preferences");
        alert.setContentText("Idiomas disponibles (cambiable en la clase App.java): Español/Inglés \n" +
                "Available languages (changeable in the App.java class): Spanish/English");
        alert.showAndWait();
    }

    // Este metodo se encarga de cerrar la aplicacion al completo.
    @FXML
    private void salirApp() {
        System.out.println("Los nombres son el boss final de la programación.");
        System.exit(0);
    }

    /* Metodo que crea un hilo, llama a una API, recoge la informacion de campos seleccionados y los enlaza al objeto.
       La lista es agregada al ListView, creada desde el editor, en el metodo "initialize" de esta misma clase.
     */
    @FXML
    private void iniciaLista() {
        int numRandom = (int) Math.floor(Math.random() * 42 + 1);
        lblNumPagina.setText("" + numRandom);
        Runnable task = () -> {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://rickandmortyapi.com/api/character?page=" + numRandom))
                    .build();
            HttpResponse<String> response = null;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                Platform.runLater(() -> listaViewPersonajes.getItems().removeAll(listaDatos));
                //JSONArray dataArray = new JSONArray(response.body().substring(163, response.body().length() - 1)); ESTO SE DEJA PARA LA POSTERIDAD.
                JSONObject responseObject = new JSONObject(response.body());
                JSONArray dataArray = new JSONArray(responseObject.getJSONArray("results"));
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject row = dataArray.getJSONObject(i);
                    Platform.runLater(() -> listaDatos.add(new Personaje(row.getInt("id"),
                            row.getString("image"),
                            row.getString("name"),
                            row.getString("status"),
                            row.getString("species"),
                            row.getString("gender"))));
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(task).start();
    }

}


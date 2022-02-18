package com.example.appcontactosii;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


import java.util.Locale;
import java.util.ResourceBundle;

// CLASE QUE INICIA LA APLICACIÓN
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale spanish = new Locale("es", "ES");
        Locale english = new Locale("en", "EN");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/strings", spanish);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("appPrincipal.fxml"), resourceBundle);

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Aplicación Rick y Morty");
        stage.setScene(scene);
        stage.setMinHeight(542);
        stage.setMinWidth(620);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.appcontactosii;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


import java.util.Locale;
import java.util.ResourceBundle;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Locale spanish = new Locale("es", "ES");
        Locale english = new Locale("en", "EN");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("i18n/strings", spanish);
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("AppView.fxml"), resourceBundle);

        Scene scene = new Scene(fxmlLoader.load());
        //scene.getStylesheets().add("App.css");
        stage.setTitle("El IntelliJ de clase me trolea con los idiomas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}
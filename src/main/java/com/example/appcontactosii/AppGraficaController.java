package com.example.appcontactosii;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class AppGraficaController {

    @FXML
    private StackPane appGrafica;
    @FXML
    private Button btnAtrasG;
    @FXML
    private BarChart graficaEdad;

    @FXML
    public void initialize() {
    }

    @FXML
    private void volverPrincipalG() {
        appGrafica.setVisible(false);
    }

}

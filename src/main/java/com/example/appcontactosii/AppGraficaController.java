package com.example.appcontactosii;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class AppGraficaController {

    @FXML
    private StackPane appGrafica;
    @FXML
    private Button btnAtrasG;
    @FXML
    private PieChart graficaGenero;

    @FXML
    public void initialize() {

        ObservableList<PieChart.Data> datosGraficoCircular = FXCollections.observableArrayList(
                new PieChart.Data("C", 0.1695f),
                new PieChart.Data("Java", 0.1256f),
                new PieChart.Data("Python", 0.1128f),
                new PieChart.Data("C++", 0.0694f),
                new PieChart.Data("C#", 0.0416f),
                new PieChart.Data("Visual Basic", 0.0397f),
                new PieChart.Data("JavaScript", 0.0214f),
                new PieChart.Data("PHP", 0.0209f),
                new PieChart.Data("R", 0.0199f),
                new PieChart.Data("SQL", 0.0157f));
        graficaGenero.setData(datosGraficoCircular);
        graficaGenero.setClockwise(false);
        graficaGenero.setTitle("Tipos de especies");
    }

    @FXML
    private void volverPrincipalG() {
        appGrafica.setVisible(false);
    }


}

package com.example.appcontactosii;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

// CONTROLADOR VISTA DE GRÁFICAS
public class AppGraficaController{

    @FXML
    private StackPane appGrafica;
    @FXML
    private Button btnAtrasG;
    @FXML
    private PieChart graficaGenero, graficaEspecie;

    private ResourceBundle resourceBundle;


    @FXML
    private void volverPrincipalG() {
        appGrafica.setVisible(false);
    }

    public void cargarDatosPieChartGenero(ObservableList<Personaje> lista) {
        int contadorMale = 0;
        for (Personaje p1 : lista) {
            if (p1.getGenero().equals("Male")) {
                contadorMale++;
            }

        }

        int contadorFemale = 0;
        for (Personaje p2 : lista) {
            if (p2.getGenero().equals("Female")) {
                contadorFemale++;
            }
        }

        int contadorUnknown = lista.size() - contadorMale - contadorFemale;

        ObservableList<PieChart.Data> datosGraficoCircular = FXCollections.observableArrayList(
                new PieChart.Data("Hombre", contadorMale),
                new PieChart.Data("Mujer", contadorFemale),
                new PieChart.Data("Desconocido", contadorUnknown));
        graficaGenero.setData(datosGraficoCircular);
        graficaGenero.setClockwise(false);
    }

    public void cargarDatosPieChartEspecie(ObservableList<Personaje> lista) {
        int contadorHuman = 0;
        for (Personaje p4 : lista) {
            if (p4.getEspecie().equals("Human")) {
                contadorHuman++;
            }

        }

        int contadorAlien = 0;
        for (Personaje p5 : lista) {
            if (p5.getEspecie().equals("Alien")) {
                contadorAlien++;
            }
        }

        int contadorResto = lista.size() - contadorAlien - contadorHuman;

        ObservableList<PieChart.Data> datosGraficoCircular = FXCollections.observableArrayList(
                new PieChart.Data("Hombre", contadorHuman),
                new PieChart.Data("Alien", contadorAlien),
                new PieChart.Data("Otros", contadorResto));
        graficaEspecie.setData(datosGraficoCircular);
        graficaEspecie.setClockwise(false);

    }

}

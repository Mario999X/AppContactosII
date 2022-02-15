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

    }

    @FXML
    private void volverPrincipalG() {
        appGrafica.setVisible(false);
    }

    public void cargarDatos(ObservableList<Personaje> lista) {
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

        int contadorUnknown = 0;
        for (Personaje p3 : lista) {
            if (p3.getGenero().equals("unknown")) {
                contadorUnknown++;
            }
        }

            ObservableList<PieChart.Data> datosGraficoCircular = FXCollections.observableArrayList(
                    new PieChart.Data("Hombre", contadorMale),
                    new PieChart.Data("Mujer", contadorFemale),
                    new PieChart.Data("Desconocido", contadorUnknown));
            graficaGenero.setData(datosGraficoCircular);
            graficaGenero.setClockwise(false);
            graficaGenero.setTitle("Género personajes");
        }

    }

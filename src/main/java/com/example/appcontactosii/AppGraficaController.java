package com.example.appcontactosii;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


import java.util.ResourceBundle;

// CONTROLADOR VISTA DE GRÁFICAS
public class AppGraficaController {

    @FXML
    private StackPane appGrafica;
    @FXML
    private PieChart graficaGenero, graficaEspecie;

    // Metodo encargado de volver invisible la vista appGrafica.
    @FXML
    private void volverPrincipalG() {
        appGrafica.setVisible(false);
    }

    /* Metodo encargado de cargar datos a un PieChart (grafico circular), le pasamos por variable una lista
        observable, en este caso nos interesa numerar la cantidad de hombres, mujeres y otros tipos de genero,
        por lo que, creando tres variables int, y usando for-each, podemos recorrer la lista.
        .equals, eso diferencia los distintos bucles, y para llevar el conteo, simplemente hacemos que aumente cada
        vez que encuentre uno con ese campo especifico. Este metodo es llamado en la AppPrincipalController, y la
        lista sera la conseguida de la API.

       La segunda parte del metodo, es la creacion de otro ObservableList, con datos de la grafica circular
       en su interior, luego simplemente daremos nombre a las variables de la propia grafica y pondremos
       los distintos contadores.
     */
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

    // Literalmente lo de arriba pero con distinta info.
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

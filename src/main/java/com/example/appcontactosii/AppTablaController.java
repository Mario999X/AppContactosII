package com.example.appcontactosii;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

public class AppTablaController {
    /// CODIGO PROFE

        @FXML private TableView tablaPersonajes;
        @FXML private TableColumn<?, ?> columnId;
        @FXML private TableColumn<?, ?> columnNombre;
        @FXML private TableColumn<?, ?> columnEstado;
        @FXML private TableColumn<?, ?> columnEspecie;
        @FXML private TableColumn<?, ?> columnGenero;
        private ObservableList<Personaje> personajeObservableList;

    /// FIN CODIGO PROFE



    @FXML
    private StackPane appTabla;

    @FXML
    private void volverPrincipalT(){
        appTabla.setVisible(false);
    }

    public void cargarTabla(ObservableList<Personaje> lista){
        //Inicializar tabla
        tablaPersonajes.setEditable(true);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columnEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        columnGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        personajeObservableList = FXCollections.observableArrayList();
        tablaPersonajes.setItems(personajeObservableList);
    }


}

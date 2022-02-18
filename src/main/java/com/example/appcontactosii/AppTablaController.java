package com.example.appcontactosii;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;

// CONTROLADOR VISTA TABLA
public class AppTablaController {
    @FXML
    private StackPane appTabla;
    @FXML
    private TableView tablaPersonajes;
    @FXML
    private TableColumn<?, ?> columnId;
    @FXML
    private TableColumn<?, ?> columnNombre;
    @FXML
    private TableColumn<?, ?> columnEstado;
    @FXML
    private TableColumn<?, ?> columnEspecie;
    @FXML
    private TableColumn<?, ?> columnGenero;

    // Metodo encargado de ocultar la vista appTabla
    @FXML
    private void volverPrincipalT() {
        appTabla.setVisible(false);
    }

    // Metodo encargado de iniciar la tabla, parecido al caso del metodo "cargarPersonaje" o los de la grafica; es llamado en AppPrincipalController
    public void cargarTabla(ObservableList<Personaje> lista) {
        // Inicializar tabla
        tablaPersonajes.setEditable(true);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columnEspecie.setCellValueFactory(new PropertyValueFactory<>("especie"));
        columnGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        tablaPersonajes.setItems(lista);

    }

}

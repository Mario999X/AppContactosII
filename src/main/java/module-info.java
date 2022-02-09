module com.example.appcontactosii {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.appcontactosii to javafx.fxml;
    exports com.example.appcontactosii;
}
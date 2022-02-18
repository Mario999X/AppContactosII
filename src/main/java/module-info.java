module com.example.appcontactosii {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.net.http;


    opens com.example.appcontactosii to javafx.fxml;
    exports com.example.appcontactosii;
}
module com.example.kyrsova_pppi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.kyrsova_pppi to javafx.fxml;
    exports com.example.kyrsova_pppi;
}
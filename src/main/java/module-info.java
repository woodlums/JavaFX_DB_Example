module com.example.fxdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.fxdb to javafx.fxml;
    exports com.example.fxdb;
}
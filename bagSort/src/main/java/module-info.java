module com.mycompany.bagsort {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;

    opens com.mycompany.bagsort to javafx.fxml;
    exports com.mycompany.bagsort;
}

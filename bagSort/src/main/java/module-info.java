module com.mycompany.bagsort {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.bagsort to javafx.fxml;
    exports com.mycompany.bagsort;
}

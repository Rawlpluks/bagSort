module com.mycompany.bagsort {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.bagsort to javafx.fxml;
    exports com.mycompany.bagsort;
}

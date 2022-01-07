package com.mycompany.bagsort;

import com.mycompany.Classes.Child;
import com.mycompany.Classes.Item;
import com.mycompany.Classes.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}

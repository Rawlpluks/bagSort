package com.mycompany.bagsort;

import com.mycompany.Classes.Child;
import com.mycompany.Classes.Item;
import com.mycompany.Classes.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SecondaryController implements Initializable{

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            HashMap<String, Integer> test = new HashMap();
            
            test.put("1", 23);
            test.put("2", 92);
            test.put("3", 88);
            test.put("4", 56);
            test.put("5", 342);
            test.put("6", 13);
            test.put("8", 34);
            test.put("7", 373);
            
            System.out.println(test.get("1"));
            test.size();
    }
}

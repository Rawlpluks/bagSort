package com.mycompany.bagsort;

import com.mycompany.Classes.Child;
import com.mycompany.Classes.Item;
import com.mycompany.Classes.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class mainScreenController implements Initializable{

    @FXML
    private Button startSim;
    @FXML
    private TextField individualsAtStart;
    @FXML
    private TextField shortenedPerGeneration;
    @FXML
    private TextField numberOfGenerations;
    @FXML
    private TextField maxTotalWeight;
    @FXML
    private TextField mutationRate;
    

    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.getCurrentSimulation().setStartIndividualsPerGeneration(1000);
        App.getCurrentSimulation().setIndividualShortendPerGeneration(0);
        App.getCurrentSimulation().setNumberOfGenerations(100);
        App.getCurrentSimulation().setMaxWeight(5000);
        App.getCurrentSimulation().setMutationRate(15);
        System.out.println("hello");
    }

    @FXML
    private void runSimulation(ActionEvent event) throws Exception{
        if(!individualsAtStart.getText().isBlank()){
            App.getCurrentSimulation().setStartIndividualsPerGeneration(Integer.parseInt(individualsAtStart.getText()));
        }
        
        if(!shortenedPerGeneration.getText().isBlank()) {
            App.getCurrentSimulation().setIndividualShortendPerGeneration(Integer.parseInt(shortenedPerGeneration.getText()));
        }
        
        if(!numberOfGenerations.getText().isBlank()) {
            App.getCurrentSimulation().setNumberOfGenerations(Integer.parseInt(numberOfGenerations.getText()));
        }
        
        if(!maxTotalWeight.getText().isBlank()) {
            App.getCurrentSimulation().setMaxWeight(Integer.parseInt(maxTotalWeight.getText()));
        }
        
        if(!mutationRate.getText().isBlank()) {
            App.getCurrentSimulation().setMutationRate(Integer.parseInt(mutationRate.getText()));
        }
        
        App.setRoot("simulation");
    }
}

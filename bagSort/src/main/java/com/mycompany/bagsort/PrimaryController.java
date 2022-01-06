package com.mycompany.bagsort;

import com.mycompany.Classes.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class PrimaryController implements Initializable{
    
    private int individualsPerGeneration = 400;
    private int individualShortendPerGeneration = 0;
    private int numberOfGenerations = 20;
    private int numberOfSimulations = 1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ArrayList<Item> items = setItems();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private ArrayList<Item> setItems() throws Exception{
        ArrayList<Item> items = new ArrayList<>();
        
        items.add(new Item("kort", 90, 150));
        items.add(new Item("kompas", 130, 35));
        items.add(new Item("vand", 1530, 200));
        items.add(new Item("sandwitch", 500, 160));
        items.add(new Item("sukker", 150, 60));
        items.add(new Item("dåsemad", 680, 45));
        items.add(new Item("banan", 270, 60));
        items.add(new Item("æble", 390, 40));
        items.add(new Item("ost", 230, 30));
        items.add(new Item("øl", 520, 10));
        items.add(new Item("solcreme", 110, 70));
        items.add(new Item("kamera", 320, 30));
        items.add(new Item("T-shirt", 240, 15));
        items.add(new Item("bukser", 480, 10));
        items.add(new Item("paraply", 730, 40));
        items.add(new Item("vandtætte bukser", 420, 70));
        items.add(new Item("vandtæt overtøj", 430, 75));
        items.add(new Item("pung", 220, 80));
        items.add(new Item("solbriller", 70, 20));
        items.add(new Item("håndklæde", 180, 12));
        items.add(new Item("sokker", 40, 60));
        items.add(new Item("bog", 300, 10));
        items.add(new Item("notesbog", 900, 1));
        items.add(new Item("telt", 2000, 150));
        
        return items;
    }
    
    private void startEvolution(){
        
        //loop number of times to run simulation
        for(int i = 0; i < numberOfSimulations; i++) {
            //create random generation
            ArrayList<Parent> parents = new ArrayList<>();
            
            for(int u = 0; u < individualsPerGeneration; u++) {

            //loop for number of generations
                //sort generation

                //display generation

                //if more needed, create new generation

            //save simulation
            //save last gen to data base whit variabels and stuff
            }
        }
        //display den bedste simulation
        
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}

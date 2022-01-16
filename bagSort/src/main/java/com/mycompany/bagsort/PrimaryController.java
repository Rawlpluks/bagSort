package com.mycompany.bagsort;

import com.mycompany.Classes.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class PrimaryController implements Initializable {

    private ArrayList<Item> items = new ArrayList<>();
    private int startIndividualsPerGeneration = 400;
    private int individualShortendPerGeneration = 0;
    private int numberOfGenerations = 20;
    private int numberOfSimulations = 1;
    private int maxWeight = 5000;
    private int collectiveFitness = 0;
    
    @FXML LineChart lineChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ArrayList<Item> items = setItems();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private ArrayList<Item> setItems() throws Exception {

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
     private float calcAverageValue(ArrayList<Parent> parents){
        float averageValue = 0;
        for(int i = 0; i < parents.size(); i++){
            averageValue += parents.get(i).getValueOfBag(items)/parents.size();
            
        }
        
        return averageValue;
    }
     
    private void startEvolution() {
        
        Comparator<Parent> sortParentsBasedOnBagValueAscending = new Comparator<Parent>()
                {
                    @Override
                    public int compare(Parent p1, Parent p2){
                        return (p1.getValueOfBag(items) < p2.getValueOfBag(items) ? -1 : (p1.getValueOfBag(items)== p2.getValueOfBag(items) ? 0 : 1));
                    }
            
                };      
        
        //loop number of times to run simulation
        for (int i = 0; i < numberOfSimulations; i++) {
            int individualsPerGeneration = startIndividualsPerGeneration;
            ArrayList<Parent> parents = new ArrayList<>();

            //create random generation
            Random random = new Random();
            for (int u = 0; u < individualsPerGeneration; u++) {

                ArrayList<Integer> newBag = new ArrayList<>();

                for (int n = 0; n < items.size(); n++) {
                    newBag.add(random.nextInt(1 + 1));
                }
                parents.add(new Parent(newBag));
            }

            //loop for number of generations
            for (int v = 1; v <= numberOfGenerations; v++) {

                //remove parents who exceed weight limit and calc fitness score
                for (int u = 0; u < parents.size(); u++) {
                    if (parents.get(u).getWeightOfBag(items) > maxWeight) {
                        parents.remove(u);
                        u--;
                    } else {
                        parents.get(u).setFitness(parents.get(u).getValueOfBag(items));
                        collectiveFitness += parents.get(u).getFitness();
                    }
                }
                //sort generation
                Collections.sort(parents, sortParentsBasedOnBagValueAscending);

                //display generation
                //shorting the number of individuals per generation
                individualsPerGeneration -= individualShortendPerGeneration;

                //if more needed, create new generation
                if (v < numberOfGenerations) {

                    // create gene pool
                    ArrayList<Parent> matingPool = new ArrayList<>();
                    for (int u = 0; u < parents.size(); u++) {
                        float procentageOfNewGeneration = parents.get(u).getFitness() / collectiveFitness;
                        int numberOfNewParents = (int) Math.round(individualsPerGeneration * procentageOfNewGeneration);
                        for (int n = 0; n < numberOfNewParents; n++) {
                            matingPool.add(parents.get(u));
                        }
                    }

                    parents.clear();
                    for (int u = 0; u < individualsPerGeneration; u++) {
                        Child child = new Child(matingPool.get(random.nextInt(matingPool.size())), matingPool.get(random.nextInt(matingPool.size())));
                        parents.add(child.asParent());
                    }

                }

            }
            //save simulation
            //save last gen to data base whit variabels and stuff

        }
        //display den bedste simulation

    }
    
    @FXML
    private void drawGraph (Graph graph) {
        XYChart.Series seriesH = new XYChart.Series();
        XYChart.Series seriesL = new XYChart.Series();
        XYChart.Series seriesA = new XYChart.Series();
        seriesH.setName("Highest value");
        seriesL.setName("Lowest value");
        seriesA.setName("Average value");
        
        for(int i = 0; i< graph.highestValues.size(); i++){
            seriesH.getData().add(new XYChart.Data(toString(i+1),graph.getHighestValues.get(toString(i+1))));
        }
        for(int i = 0; i< graph.lowestValues.size(); i++){
            seriesL.getData().add(new XYChart.Data(toString(i+1),graph.getLowestValues.get(toString(i+1))));
        }
        for(int i = 0; i< graph.averageValues.size(); i++){
            seriesA.getData().add(new XYChart.Data(toString(i+1),graph.getAverageValues.get(toString(i+1))));
        }
        
        //adding series to lineChart
        lineChart.getData().add(seriesH);
        lineChart.getData().add(seriesL);
        lineChart.getData().add(seriesA);
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author Clara Maj
 */
public class Graph {
    //add graph data
    
    private HashMap<String, Integer> highestValues = new HashMap();
    private HashMap<String, Integer> lowestValues = new HashMap();
    private HashMap<String, Integer> averageValues = new HashMap();

    public Graph() {
    }
    
    public void updateGraphData(ArrayList<Parent> generation, ArrayList<Item> items) {
        //make arraylist of values
        ArrayList<Integer> values = new ArrayList<>();
        int totalValue = 0;
        for(Parent i : generation){
            values.add(i.getValueOfBag(items));
            totalValue += i.getValueOfBag(items);
        }

        //get higehst value
        highestValues.put(String.valueOf(highestValues.size() + 1), Collections.max(values));
        
        //get lowest value
        lowestValues.put(String.valueOf(lowestValues.size() + 1), Collections.min(values));
        
        //get average value
        averageValues.put(String.valueOf(averageValues.size() + 1), (totalValue / values.size()));
    }
    
    public HashMap<String, Integer> getHighestValues() {
        return highestValues;
    }

    public HashMap<String, Integer> getLowestValues() {
        return lowestValues;
    }

    public HashMap<String, Integer> getAverageValues() {
        return averageValues;
    }
    
    
}


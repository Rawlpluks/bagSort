/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Classes;

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


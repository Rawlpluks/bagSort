/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Classes;

import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class Parent extends Individuals{
    
    private int fitness;
    
    public Parent(ArrayList<Integer> bag) {
        super(bag);
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
        
    public int getWeightOfBag(ArrayList<Item> items){
        int totalWeight = 0;
        for(int i = 0; i < getBag().size(); i++){
            if(getBag().get(i) == 1){
                totalWeight += items.get(i).getWeight();
            }
        }        
        return totalWeight;
    }
    
    public int getValueOfBag(ArrayList<Item> items){
        int totalValue = 0;
        for(int i = 0; i < getBag().size(); i++){
        if(getBag().get(i) == 1){
            totalValue += items.get(i).getValue();
            }
        }
        return totalValue;
    }
}

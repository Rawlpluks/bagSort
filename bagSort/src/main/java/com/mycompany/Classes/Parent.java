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
    
    public int getWeightOfBag(){
        return 0;
    }
    
    public int getValueOfBag(){
        return 0;
    }
}

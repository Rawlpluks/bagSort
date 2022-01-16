/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Classes;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author chris
 */
public class Child extends Individuals {

    private int chanceOfMutating = 5; // in %

    private void setChildsBag(Parent parent1, Parent parent2) {
        ArrayList<Integer> tempBag = new ArrayList<>();

        int totalFitness = parent1.getFitness() + parent2.getFitness();
        float parent1Wieght = parent1.getFitness() / totalFitness * 100;
        Random x = new Random();
        
        //looping through the bag to se for ever gene,
        //if ite mutatets, gets its first parents gene or if it gets the second parents gene
        for (int i = 0; i < parent1.getBag().size(); i++) {
            if ((x.nextInt(100) + 1) < chanceOfMutating) {
                //mutation
                tempBag.add(x.nextInt(2));
                
            } else if ((x.nextInt(100) + 1) < parent1Wieght) {
                //parent 1
                tempBag.add(parent1.getBag().get(i));

            } else {
                //parent 2
                tempBag.add(parent2.getBag().get(i));

            }
        }
        setBag(tempBag);
    }

    public Child(Parent parent1, Parent parent2) {
        super(null);

        setChildsBag(parent1, parent2);
    }

    public void setChanceOfMutating(int chanceOfMutating) {
        this.chanceOfMutating = chanceOfMutating;
    }
}

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
public class Individuals {
    private ArrayList<Integer> bag;

    public Individuals(ArrayList<Integer> bag) {
        this.bag = bag;
    }

    public ArrayList<Integer> getBag() {
        return bag;
    }

    public void setBag(ArrayList<Integer> bag) {
        this.bag = bag;
    }
}

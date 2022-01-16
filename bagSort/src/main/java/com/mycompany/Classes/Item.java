 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Classes;

/**
 *
 * @author chris
 */
public class Item {
    private int item_ID;
    private String name;
    private int weight;
    private int value;

    public Item(int item_ID, String name, int weight, int value) {
        this.item_ID = item_ID;
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
    
    public Item(String name, int weight, int value) {
        this.item_ID = item_ID;
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public int getItem_ID() {
        return item_ID;
    }
    
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }
}

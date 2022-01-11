/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Classes;

import com.mycompany.Classes.Graph;

/**
 *
 * @author Clara Maj
 */
public class Simulation {
    private int simulation_ID;
    private int itemSet_ID;
    private int numberOfGenerations;
    private int startIndividualsPerGeneration;
    private int individualShortendPerGeneration;
    private int maxWeight;
    private int bestValue;
    private int worstValue;
    private int averageValue;
    private int timeUsed;
    private Graph graph;

    public Simulation(int simulation_ID, int itemSet_ID, int numberOfGenerations, int startIndividualsPerGeneration, int individualShortendPerGeneration, int maxWeight, int bestValue, int worstValue, int averageValue, int timeUsed, Graph graph) {
        this.simulation_ID = simulation_ID;
        this.itemSet_ID = itemSet_ID;
        this.numberOfGenerations = numberOfGenerations;
        this.startIndividualsPerGeneration = startIndividualsPerGeneration;
        this.individualShortendPerGeneration = individualShortendPerGeneration;
        this.maxWeight = maxWeight;
        this.bestValue = bestValue;
        this.worstValue = worstValue;
        this.averageValue = averageValue;
        this.timeUsed = timeUsed;
        this.graph = graph;
    }

    public int getSimulation_ID() {
        return simulation_ID;
    }

    public int getItemSet_ID() {
        return itemSet_ID;
    }

    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public int getStartIndividualsPerGeneration() {
        return startIndividualsPerGeneration;
    }

    public int getIndividualShortendPerGeneration() {
        return individualShortendPerGeneration;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getBestValue() {
        return bestValue;
    }

    public int getWorstValue() {
        return worstValue;
    }

    public int getAverageValue() {
        return averageValue;
    }

    public int getTimeUsed() {
        return timeUsed;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setSimulation_ID(int simulation_ID) {
        this.simulation_ID = simulation_ID;
    }

    public void setItemSet_ID(int itemSet_ID) {
        this.itemSet_ID = itemSet_ID;
    }

    public void setNumberOfGenerations(int numberOfGenerations) {
        this.numberOfGenerations = numberOfGenerations;
    }

    public void setStartIndividualsPerGeneration(int startIndividualsPerGeneration) {
        this.startIndividualsPerGeneration = startIndividualsPerGeneration;
    }

    public void setIndividualShortendPerGeneration(int individualShortendPerGeneration) {
        this.individualShortendPerGeneration = individualShortendPerGeneration;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setBestValue(int bestValue) {
        this.bestValue = bestValue;
    }

    public void setWorstValue(int worstValue) {
        this.worstValue = worstValue;
    }

    public void setAverageValue(int averageValue) {
        this.averageValue = averageValue;
    }

    public void setTimeUsed(int timeUsed) {
        this.timeUsed = timeUsed;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    
    
}

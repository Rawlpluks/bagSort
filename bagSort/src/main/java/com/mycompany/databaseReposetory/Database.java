/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databaseReposetory;

/**
 *
 * @author Clara Maj
 */
import com.mycompany.Classes.*;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    private String connectionString;
    
    
    private ArrayList<Item> loadItems (ResultSet rs) throws SQLException, Exception{
        ArrayList<Item> items = new ArrayList<>();
        
        while(rs.next()){
            items.add(new Item(rs.getInt("item_ID"), rs.getString("name"), rs.getInt("weight"), rs.getInt("value")));
        }
        
        return items;
    }
    
    //-------------------------------------
    //---------- save simulation ----------
    //-------------------------------------
    public void saveSimulation(Simulation _simulation) throws SQLException, Exception {
        Class.forName("org.sqlite.JDBC");

        Connection conn = null;
        String sql;

        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            //Skrive fejlhåndtering her
            System.out.println("\n Database error (save simulation (conn): " + e.getMessage() + "\n");
        }

        //make graph
        //get graph id
        int graph_ID = 0;

        sql = "INSERT INTO Simulation(itemSet_ID, graph_ID, numberOfGenerations, startIndividualsPerGeneration, "
                + "individualShortenedPerGeneration, maxWeight, bestValue, worstValue, averageValue, timeUsed, mutationRate) "
                + "VALUES('" + _simulation.getItemSet_ID() + "','" + graph_ID + "','" + _simulation.getNumberOfGenerations() + "',"
                + "'" + _simulation.getStartIndividualsPerGeneration() + "','" + _simulation.getIndividualShortendPerGeneration() + "',"
                + "'" + _simulation.getMaxWeight() + "','" + _simulation.getBestValue() + "','" + _simulation.getWorstValue() + "',"
                + "'" + _simulation.getAverageValue() + "','" + _simulation.getTimeUsed() + "', '" + _simulation.getMutationRate() + "');";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("\n Database error (save simulation (sql): " + e.getMessage() + "\n");
        }

        conn.close();
    }
    
    //-------------------------------------
    //---------- get simulations ----------
    //-------------------------------------
    private ArrayList<Simulation> getSimulations() throws SQLException, Exception {
        ArrayList<Simulation> importedSimulations = new ArrayList<>();

        Connection conn = null;
        Class.forName("org.sqlite.JDBC");

        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            //Skrive fejlhåndtering her
            System.out.println("\n Database error (get simulation (conn): " + e.getMessage() + "\n");
        }

        try {
            Statement stat = conn.createStatement();

            ResultSet rs = stat.executeQuery("SELECT * FROM Simulations");
            rs.next();

            while (rs.next()) {
                Simulation currentSimulation = new Simulation(rs.getInt("Simulation_ID"), rs.getInt("itemSet_ID"), rs.getInt("numberOfGenerations"),
                        rs.getInt("startIndividualsPerGeneration"), rs.getInt("individualShortendPerGeneration"), rs.getInt("maxWeight"),
                        rs.getInt("bestValue"), rs.getInt("worsteValue"), rs.getInt("averageValue"), rs.getInt("timeUsed"), rs.getInt("mutationRate"), null);

                ResultSet rsGraph = stat.executeQuery("SELECT * FROM Graph WHERE Graph_ID =('" + rs.getInt("graph_ID") + "')");
                Graph currentGraph = new Graph();

                currentSimulation.setGraph(currentGraph);

                importedSimulations.add(currentSimulation);
            }

        } catch (SQLException e) {
            System.out.println("\n Database error (get simulation (): " + e.getMessage() + "\n");
        }
        
        conn.close();
        
        return importedSimulations;
    }
    
    //---------------------------------------
    //---------- delete simulation ----------
    //---------------------------------------
    
    //-------------------------------
    //---------- Get items ----------
    //-------------------------------
    private ArrayList<Item> getItems() throws SQLException, Exception {
        ArrayList<Item> items = new ArrayList<>();
        
        Connection conn = null;
        Class.forName("org.sqlite.JDBC");

        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            //Skrive fejlhåndtering her
            System.out.println("\n Database error (get simulation (conn): " + e.getMessage() + "\n");
        }
        
        try {
            Statement stat = conn.createStatement();
            
            ResultSet rs = stat.executeQuery("SELECT * FROM Items");
            
            items = loadItems(rs);
                    
        } catch (SQLException e) {
            System.out.println("\n Database error (get simulation (conn): " + e.getMessage() + "\n");
        }
        
        return items;
    }
    
    //---------------------------------
    //---------- create item ----------
    //---------------------------------
    //private void createItem(Item item) throws SQLException, Exception
    
    //---------------------------------
    //---------- delete item ----------
    //---------------------------------
    
    //-----------------------------------
    //---------- get item sets ----------
    //-----------------------------------
    
    //-------------------------------------
    //---------- create item set ----------
    //-------------------------------------
    
    //-------------------------------------
    //---------- delete item set ----------
    //-------------------------------------
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databaseReposetory;

/**
 *
 * @author Clara Maj
 */
import com.mycompany.Classes.Graph;
import com.mycompany.Classes.Simulation;
import java.sql.*;
import java.util.ArrayList;

public class Database {
    private String connectionString;
    
    public void saveSimulation(Simulation _simulation) throws SQLException, Exception{
         Class.forName("org.sqlite.JDBC");
         
         Connection conn = null;
         String sql;
         
        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            //Skrive fejlhåndtering her
            System.out.println("\n Database error (check for matching user (connection): " + e.getMessage() + "\n");
        }
        
        //make graph
        //get graph id
        int graph_ID = 0;
        
        sql = "INSERT INTO Simulation(itemSet_ID, graph_ID, numberOfGenerations, startIndividualsPerGeneration, "
                + "individualShortenedPerGeneration, maxWeight, bestValue, worstValue, averageValue, timeUsed) "
                + "VALUES('" + _simulation.getItemSet_ID() + "','" + graph_ID + "','" + _simulation.getNumberOfGenerations() + "',"
                + "'" + _simulation.getStartIndividualsPerGeneration() + "','" + _simulation.getIndividualShortendPerGeneration() + "',"
                + "'" + _simulation.getMaxWeight() + "','" + _simulation.getBestValue() + "','" + _simulation.getWorstValue() + "',"
                + "'"  + _simulation.getAverageValue() + "','" + _simulation.getTimeUsed() + "');";
        
         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "\n");
        }
         
        conn.close();
    }
    
    private ArrayList<Simulation> getSimulation () throws SQLException, Exception {
        Connection conn = null;
        Class.forName("org.sqlite.JDBC");
        
        try {
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            //Skrive fejlhåndtering her
            System.out.println(e.getMessage() + "\n");
        }
        
        try {
            Statement stat = conn.createStatement();
            
            ResultSet rs = stat.executeQuery("SELECT * FROM Simulations");
            rs.next();
            
            ArrayList<Simulation> importedSimulations = new ArrayList<>();
            
            while(rs.next()){
              Simulation currentSimulation = new Simulation(rs.getInt("Simulation_ID"), rs.getInt("itemSet_ID"), rs.getInt("numberOfGenerations"), 
                      rs.getInt("startIndividualsPerGeneration"), rs.getInt("individualShortendPerGeneration"), rs.getInt("maxWeight"), 
                      rs.getInt("bestValue"), rs.getInt("worsteValue"), rs.getInt("averageValue"), rs.getInt("timeUsed"), null);
            
              ResultSet rsGraph = stat.executeQuery("SELECT * FROM Graph WHERE Graph_ID =('" + rs.getInt("graph_ID") + "')");
              Graph currentGraph = new Graph();
              
              currentSimulation.setGraph(currentGraph);
              
              importedSimulations.add(currentSimulation);
            }
                    
        } catch (Exception e) {
        }
        
        
    
    }
}

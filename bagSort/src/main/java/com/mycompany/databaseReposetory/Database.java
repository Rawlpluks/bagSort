/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databaseReposetory;

/**
 *
 * @author Clara Maj
 */
import com.mycompany.Classes.Simulation;
import java.sql.*;

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
        
        sql = "INSERT INTO Simulation(itemSet_ID, graph_ID, numberOfGeneration, startIndividualsPerGeneration, "
                + "individualShortenedPerGeneration, maxWeight, bestValue, worstValue, averageValue, timeUsed) "
                + "VALUES('" + _simulation.getItemSet_ID() + "','" + _simulation.getGraph() + "','" + _simulation.getNumberOfGenerations() + "',"
                + "'" + _simulation.getStartIndividualsPerGeneration() + "','" + _simulation.getIndividualShortendPerGeneration() + "',"
                + "'" + _simulation.getMaxWeight() + "','" + _simulation.getBestValue() + "','" + _simulation.getWorstValue() + "',"
                + "'"  + _simulation.getAverageValue() + "','" + _simulation.getTimeUsed() + "');";
        
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.resources.controllers;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

/**
 *
 * @author Admin
 */
public class DatabaseConnection {
     private final String MYSQL_URL;
    final String DB_URL;
    private Connection sqlConnection,
            dbConnection;
    private Statement statement; 
    private final String USER_NAME;
    private final String PASSWORD; 

    public DatabaseConnection() throws SQLException {
        MYSQL_URL = "jdbc:mysql://localhost:3306"; //use this to database url
        DB_URL = MYSQL_URL + "/yourallydb"; //use this to connect to the database
        //initialise MySql usename and password 
        USER_NAME = "root";
        PASSWORD = "root";

        statement = null;
          
        String databaseName = "";

        try {
            sqlConnection = DriverManager.getConnection(MYSQL_URL, USER_NAME, PASSWORD);
            statement = sqlConnection.createStatement();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        try {
            //get the list of databases
            ResultSet dbData = sqlConnection.getMetaData().getCatalogs();
            boolean dbExists = false;
            //iterate each catalog in the ResultSet 
            while (dbData.next()) {
                // Get the database name, which is at position 1
                databaseName = dbData.getString(1);
                // Test print of database names, can be removed
                // System.out.printf("%s ",databaseName);  
                if (databaseName.equalsIgnoreCase("yourallydb")) {
                    dbExists = true;
                }
            }
            
            if (sqlConnection != null) {
                sqlConnection.close(); //close the existing connection 
            }

            //connect to database
            dbConnection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            statement = dbConnection.createStatement(); 

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            e.printStackTrace();
            return;
        }
        return;

    } 
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.resources.controllers;


import com.project.yourally.entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LoginController {

    public String authenticateUser(User loginBean) {

        try {

            String userName = loginBean.getEmail(); //Assign user entered values to temporary variables.
            String password = loginBean.getPassword();
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = (Connection) dbConnection;
            Statement statement = null;
            ResultSet resultSet = null;
            String userNameDB = "";
            String passwordDB = "";
            try {
                statement = connection.createStatement(); //Statement is used to write queries. Read more about it.
                resultSet = statement.executeQuery("select email,password from users"); //the table name is users and userName,password are columns. Fetching all the records and storing in a resultSet.
                while (resultSet.next()) // Until next row is present otherwise it return false
                {
                    userNameDB = resultSet.getString("email"); //fetch the values present in database
                    passwordDB = resultSet.getString("password");
                    if (userName.equals(userNameDB) && password.equals(passwordDB)) {
                        return "SUCCESS"; ////If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Invalid user credentials"; // Return appropriate message in case of failure
    }
}

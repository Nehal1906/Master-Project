/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.resources.controllers;


import com.project.yourally.entity.AppointmentStatus;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AppointmentStatusController extends HttpServlet{
     public void getAllAppointments(HttpServletRequest request, HttpServletResponse response){
           List<AppointmentStatus> status = new ArrayList<>();
            try { 
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = (Connection) dbConnection;
            String query = "SELECT * FROM appointment";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                AppointmentStatus st = new AppointmentStatus (resultSet.getString("Status")); // model obj

                   status.add(st); // add model obj into list
                   
            }
           // request.setAttribute("Status", Status);
            //request.getRequestDispatcher("AppointmentStatsu.html").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessionalConsulatationController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
     }
    
}

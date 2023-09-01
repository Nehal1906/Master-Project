/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.AppointmentStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nehal
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

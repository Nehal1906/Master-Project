/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entity.HelperDetail;
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
 * @author jharna
 */
public class ProfessionalConsulatationController extends HttpServlet{

    public void getProfessionalHelper(HttpServletRequest request, HttpServletResponse response){
        List<HelperDetail> items = new ArrayList<>();
        try { 
            DatabaseConnection dbConnection = new DatabaseConnection();
            Connection connection = (Connection) dbConnection;
            String query = "SELECT * FROM helperdetail";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                HelperDetail item = new HelperDetail(); 
                item.setUserId(resultSet.getInt("userid"));
                
                String findUser = "Select firstname, lastname from user where id = "+item.UserId+"";
                item.setSpecialization(resultSet.getString("Specialization")); 
                item.setDescription(resultSet.getString("Description"));
                item.setLicenceNumber(resultSet.getString("LicenceNumber"));
                item.setFirstName(resultSet.getString("firstName"));
                item.setLastName(resultSet.getString("lastName"));
                items.add(item);
            }
            request.setAttribute("items", items);
            //request.getRequestDispatcher("ProfessionalHelp.html").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(ProfessionalConsulatationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

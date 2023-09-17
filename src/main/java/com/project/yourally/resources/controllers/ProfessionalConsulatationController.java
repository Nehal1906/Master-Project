/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.resources.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.project.yourally.entity.HelperDetail;
import com.project.yourally.repository.HelperDetailRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
@Path("helper")
public class ProfessionalConsulatationController extends HttpServlet{

    HelperDetailRepository helperRespository;
    @GET
    @Path("list")
    public Response getAllHelper()
    {
        helperRespository = new HelperDetailRepository();
        
        List<HelperDetail> list=null;
        list = helperRespository.getAllHelpers();
        
       
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "{}";
        try {
          
            json = ow.writeValueAsString(list);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
   
    
    
    
    
}

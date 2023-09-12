/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.resources.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.project.yourally.entity.Appointment;
import com.project.yourally.entity.User;
import com.project.yourally.repository.AppointmentRepository;
import com.project.yourally.utils.APIResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
@Path("book")
public class AppointmentController implements Serializable  {
    
     private static final long serialVersionUID = 1L;
    @POST
    @Path("newbook")
    public Response bookNow(Appointment appointment)
    {
        APIResponse res= new APIResponse();
        
        AppointmentRepository respository = new AppointmentRepository();
        res = respository.createAppointment(appointment);
        
          ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "{}";
        try {
            json = ow.writeValueAsString(res);
            json = ow.writeValueAsString(res);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.ok(json, MediaType.APPLICATION_JSON).build();
      
    }
    
    @POST
    @Path("listbyuser")
    public Response getBookingByUser(User user)
    {
        AppointmentRepository respository = new AppointmentRepository();
        List<Appointment> list= null;
         list = respository.getUserAppointment(user);
        
       
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

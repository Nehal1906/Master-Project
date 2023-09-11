/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.resources.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.project.yourally.entity.User;
import com.project.yourally.repository.UserRepository;
import com.project.yourally.utils.APIResponse;
import jakarta.inject.Inject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import java.io.Serializable;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
@Path("user")

public class UserController implements Serializable {

    private static final long serialVersionUID = 1L;
   

    private String searchName;

    private UserRepository userRepository;
    private User user;
//    

//    @PostConstruct
//    public void init() {
//            this.user = new User(); 
//    }
//    
    @POST
    @Path("login")
    public Response checkUser(User user) {
        userRepository = new UserRepository();
        user.IsSeeker = true;
        user.IsHelper = false;
        System.out.println("Gettin " + user.Email);
        User user1 = userRepository.findByEmail(user.Email);
        APIResponse res = new APIResponse();

        if (user1 == null) {
            res.setCode(0);
            res.setMessage("Invalid Details Provided");
        } else if (user1.Password.equals(user.Password)) {
            res.setCode(user1.UserId);
           
           

            res.setMessage("Login Success");
        } else {
            res.setCode(0);
            res.setMessage("Authentication Failed");
        }

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
    @Path("register")
    public Response createUser(User user) {

        userRepository = new UserRepository();
        user.IsSeeker = true;
        user.IsHelper = false;
        APIResponse res = userRepository.setUserData(user);
        // this.user = userRepository.findAll();
        // this.user = new User();

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

}

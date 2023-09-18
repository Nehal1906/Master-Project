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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("user")

public class UserController implements Serializable {

    private static final long serialVersionUID = 1L;

    private String searchName;

    private UserRepository userRepository;
    private User user;
     

     /*
        checkUser method return json object with logged in user credential authentication
    */
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

    /*
        getUserById method return json object with user object
    */
    @POST
    @Path("getuser")
    public Response getUserById(User user) {
        userRepository = new UserRepository();
        user.IsSeeker = true;
        user.IsHelper = false;

        User user1 = userRepository.findById(user.UserId);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "{}";
        try {
            json = ow.writeValueAsString(user1);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    /*
        createUser method return json object and create a new user
    */
    @POST
    @Path("register")
    public Response createUser(User user) {

        userRepository = new UserRepository();
        user.IsSeeker = true;
        user.IsHelper = false;
        user.IsAdmin = false;
        user.CreatedDate = new Date();
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

    /*
        updateProfile method return json object and update user details
    */
    @POST
    @Path("updateprofile")
    public Response updateProfile(User user) {

        userRepository = new UserRepository();
        user.IsSeeker = true;
        user.IsHelper = false;
        APIResponse res = userRepository.updateProfile(user);
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

    /*
        changePassword method return json object and change password
    */
    @POST
    @Path("changepassword")
    public Response changePassword(User user) {

        userRepository = new UserRepository();
        user.IsSeeker = true;
        user.IsHelper = false;
        APIResponse res = userRepository.changePassword(user);
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

    /*
        forgotPassword method return json object
    */
    @POST
    @Path("forgot")
    public Response forgotPassword(User user) {

        userRepository = new UserRepository();
        user.IsSeeker = true;
        user.IsHelper = false;
        APIResponse res = userRepository.forgotPassword(user);
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

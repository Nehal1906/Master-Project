/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.resources.controllers;

import com.project.yourally.entity.Resource;
import com.project.yourally.repository.ResourceRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
@Path("resources")
public class ResourceController {

    @GET
    @Path("list")
    public Response getAllResource() {
        ResourceRepository resourceRepository = new ResourceRepository();

        List<Resource> list = new ArrayList<>();

        list= resourceRepository.getAll();
        
        return Response.ok(list).build();
    }

}

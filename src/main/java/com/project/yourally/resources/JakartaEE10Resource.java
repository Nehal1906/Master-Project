package com.project.yourally.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
 
@Path("jakartaee10")
public class JakartaEE10Resource {
    
    @GET
    public Response ping(){
        System.out.println("Called" + new java.util.Date().toGMTString());
      
        String json="{name:Jadeja,age:43}";
        
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
      
    }
}

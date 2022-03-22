package com.axonactive.jpa.controller;


import com.axonactive.jpa.controller.request.AssignmentRequest;
import com.axonactive.jpa.service.AssignmentService;
import com.axonactive.jpa.service.JWTAuthenticationService;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/assignments")
@Api(value = "AssugmentJWT")
@Produces(MediaType.APPLICATION_JSON)
public class AssignmentController {

    @Inject
    private AssignmentService assignmentService;
    @Inject
    JWTAuthenticationService jwtAuthenticationServicep;
    @GET
    public Response getAssignments(){
        return Response.ok(assignmentService.getAssignments()).build();
    }

    @GET
    @Path("/{id}")
    public Response getAssignmentById(@HeaderParam("Authorization") String authorization,@PathParam("id") int id){
        jwtAuthenticationServicep.checkAuthorized(authorization);
        return Response.ok(assignmentService.getAssignmentById(id)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAssignment(AssignmentRequest assignmentRequest){
        return Response.ok(assignmentService.addAssignment(assignmentRequest)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAssignment(@PathParam("id") int id){
        assignmentService.deleteAssignment(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAssignment(@PathParam("id") int assignmentId, AssignmentRequest assignmentRequest){
        return Response.ok(assignmentService.updateAssignment(assignmentId,assignmentRequest)).build();
    }
}


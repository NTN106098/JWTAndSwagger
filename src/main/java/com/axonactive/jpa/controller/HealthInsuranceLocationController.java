package com.axonactive.jpa.controller;

import com.axonactive.jpa.entity.HealthInsuranceLocation;
import com.axonactive.jpa.service.HealthInsuranceLocationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("health-insurance-location")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HealthInsuranceLocationController {

    @Inject
    HealthInsuranceLocationService healthInsuranceLocationService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{location}")
    public Response addHealthInsuranceLocation(@PathParam("location") String location) {
        return Response.ok(healthInsuranceLocationService.addHealthInsuranceLocation(location)).build();
    }
}

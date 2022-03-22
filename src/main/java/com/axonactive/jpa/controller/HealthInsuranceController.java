//package com.axonactive.jpa.controller;
//
//import com.axonactive.jpa.controller.request.HealthInsuranceRequest;
//import com.axonactive.jpa.service.HealthInsuranceService;
//
//import javax.inject.Inject;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("employees")
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class HealthInsuranceController {
//
//    @Inject
//    HealthInsuranceService healthInsuranceService;
//
//    @GET
//    @Path("/health-insurance/search-by-name")
//    public Response getAllHealthInsuranceDTOByEmployeeName(@QueryParam("employeeName") String employeeName) {
//        return Response.ok(healthInsuranceService.getAllHealthInsuranceDTOByEmployeeName(employeeName)).build();
//    }
//
////    @GET
////    @Path("/health-insurance")
////    public Response getAllHealthInsurance() {
////        return Response.ok(healthInsuranceService.getAllHealthInsurance()).build();
////    }
//
//    @GET
//    @Path("/{employeeId}/health-insurance")
//    public Response getAllHealthInsuranceDTOByEmployeeId(@PathParam("employeeId") int employeeId) {
//        return Response.ok(healthInsuranceService.getHealthInsuranceDTOByEmployeeId(employeeId)).build();
//    }
//
//    @POST
//    @Path("/{employeeId}/health-insurance")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addHealthInsurance(@PathParam("employeeId") int employeeId, HealthInsuranceRequest healthInsuranceRequest) {
//        return Response.ok(healthInsuranceService.addHealthInsurance(employeeId, healthInsuranceRequest)).build();
//    }
//
//    @PUT
//    @Path("/health-insurance/{code}")
//    public Response updateHealthInsurance(@PathParam("code") String code, HealthInsuranceRequest healthInsuranceRequest) {
//        return Response.ok(healthInsuranceService.updateHealthInsurance(code, healthInsuranceRequest)).build();
//    }
//
//    @DELETE
//    @Path("/health-insurance/{code}")
//    public Response deleteHealthInsurance(@PathParam("code") String code) {
//        healthInsuranceService.deleteHealthInsurance(code);
//        return Response.ok().build();
//    }
//
//    @GET
//    public Response getAllHealthInsurance() {
//        return Response.ok(healthInsuranceService.getAllHealthInsurance()).build();
//    }
//}

package com.axonactive.jpa.controller;

import com.axonactive.jpa.controller.request.DepartmentRequest;
import com.axonactive.jpa.service.DepartmentService;
import com.axonactive.jpa.service.JWTAuthenticationService;
import io.swagger.annotations.Api;

import javax.inject.Inject;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("departments")
@Api(value = "DepartmentJWT")
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentController {

    @Inject
    private DepartmentService departmentService;

    @Inject
    JWTAuthenticationService jwtAuthenticationServicep;

    @GET
    public Response getAllDepartments(){
        return Response.ok(departmentService.getAllDepartment()).build();
    }


    @GET
    @Path("/{id}")
    public Response getDepartmentById(@HeaderParam("Authorization") String authorization,@PathParam("id") int id){
        jwtAuthenticationServicep.checkAuthorized(authorization);
        return Response.ok(departmentService.getDepartmentById(id)).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDepartment(DepartmentRequest departmentRequest){
        return Response.ok(departmentService.addDepartment(departmentRequest)).build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteDepartment(@PathParam("id") int id){
        departmentService.deleteDepartment(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateDepartment(@PathParam("id") int id, DepartmentRequest departmentRequest){
        return Response.ok(departmentService.updateDepartment(id,departmentRequest)).build();
    }

//    @GET
//    @Path("/get-employees")
//    public Response getEmployeesWorkInDept(@QueryParam("year") @Min(2000)  @Max(2200) int year) {
//        return Response.ok(departmentService.getEmployeesWorkInDept(year)).build();
//    }

}

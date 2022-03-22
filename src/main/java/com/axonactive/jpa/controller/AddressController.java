package com.axonactive.jpa.controller;

import com.axonactive.jpa.controller.request.AddressRequest;
import com.axonactive.jpa.entity.Address;
import com.axonactive.jpa.entity.enumerate.AddressType;
import com.axonactive.jpa.service.AddressService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AddressController {
    @Inject
    AddressService addressService;

    @GET
    @Path("/{employeeId}/addresses")
    public Response getAllAddressesByEmployeeId(@PathParam("employeeId") int employeeId) {
        return Response.ok(addressService.getAllAddressesByEmployeeId(employeeId)).build();
    }

    @POST
    @Path("/addresses")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAddress(AddressRequest addressRequest){
        return Response.ok(addressService.addAddress(addressRequest)).build();
    }

    @PUT
    @Path("/{employeeId}/addresses")
    public Response updateAddress(@PathParam("employeeId") int employeeId, AddressRequest addressRequest) {
        return Response.ok(addressService.updateAddress(employeeId, addressRequest)).build();
    }

    @DELETE
    @Path("/{employeeId}/addresses/{addressType}")
    public Response deleteAddress(@PathParam("employeeId") int employeeId, @PathParam("addressType")AddressType addressType) {
        addressService.deleteAddress(employeeId, addressType);
        return Response.ok().build();
    }
}

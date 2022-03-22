package com.axonactive.jpa.service;

import com.axonactive.jpa.controller.request.AddressRequest;
import com.axonactive.jpa.entity.Address;
import com.axonactive.jpa.entity.enumerate.AddressType;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddressesByEmployeeId(int employeeId);

    Address addAddress(AddressRequest addressRequest);

    Address updateAddress(int employeeId, AddressRequest addressRequest);

    void deleteAddress(int employeeId, AddressType addressType);
}

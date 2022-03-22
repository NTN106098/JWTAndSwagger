package com.axonactive.jpa.controller.request;

import com.axonactive.jpa.entity.enumerate.AddressType;
import com.axonactive.jpa.entity.enumerate.Location;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
    @NonNull
    private int employeeId;
    private String preAddress;
    private Location postAddress;
    private AddressType addressType;
}

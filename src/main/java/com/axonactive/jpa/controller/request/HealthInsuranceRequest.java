package com.axonactive.jpa.controller.request;

import com.axonactive.jpa.entity.HealthInsuranceLocation;
import com.axonactive.jpa.entity.enumerate.AddressType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class HealthInsuranceRequest {
    private String code;
    private AddressType addressType;
    private int healthInsuranceLocationId;
    private LocalDate expirationDate;
}

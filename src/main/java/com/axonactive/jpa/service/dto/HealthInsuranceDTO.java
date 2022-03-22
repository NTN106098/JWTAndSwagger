package com.axonactive.jpa.service.dto;

import com.axonactive.jpa.entity.Address;
import com.axonactive.jpa.entity.enumerate.Location;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HealthInsuranceDTO {
    private String employeeName;
    private int yearOfBirth;
    private String code;
    private String fullAddress;
    private Location location;
    private LocalDate expirationDate;
}

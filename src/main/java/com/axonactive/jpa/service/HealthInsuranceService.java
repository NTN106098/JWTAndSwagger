package com.axonactive.jpa.service;

import com.axonactive.jpa.controller.request.HealthInsuranceRequest;
import com.axonactive.jpa.entity.HealthInsurance;
import com.axonactive.jpa.service.dto.HealthInsuranceDTO;

import java.util.List;

public interface HealthInsuranceService {
    List<HealthInsuranceDTO> getHealthInsuranceDTOByEmployeeId(int employeeId);
    List<HealthInsuranceDTO> getAllHealthInsurance();

    HealthInsurance addHealthInsurance(int employeeId, HealthInsuranceRequest healthInsuranceRequest);

    HealthInsurance updateHealthInsurance(String code, HealthInsuranceRequest healthInsuranceRequest);

    void deleteHealthInsurance(String code);

    List<HealthInsurance> getAllHealthInsuranceDTOByEmployeeName(String employeeName);
}

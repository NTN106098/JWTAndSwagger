package com.axonactive.jpa.service.mapper;

import com.axonactive.jpa.entity.HealthInsurance;
import com.axonactive.jpa.service.dto.HealthInsuranceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface HealthInsuranceMapper {
    HealthInsuranceDTO healthInsuranceToHealthInsuranceDTO(HealthInsurance healthInsurance);
}

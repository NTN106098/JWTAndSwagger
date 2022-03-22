package com.axonactive.jpa.service.impl;

import com.axonactive.jpa.entity.HealthInsuranceLocation;
import com.axonactive.jpa.entity.enumerate.Location;
import com.axonactive.jpa.service.HealthInsuranceLocationService;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
@Transactional
public class HealthInsuranceLocationServiceImpl implements HealthInsuranceLocationService {

    @PersistenceContext(name = "jpa")
    EntityManager entityManager;

    @Override
    public HealthInsuranceLocation addHealthInsuranceLocation(String location) {
        HealthInsuranceLocation healthInsuranceLocation = new HealthInsuranceLocation();
        healthInsuranceLocation.setLocation(Location.valueOf(location));
        entityManager.persist(healthInsuranceLocation);
        return healthInsuranceLocation;
    }
}

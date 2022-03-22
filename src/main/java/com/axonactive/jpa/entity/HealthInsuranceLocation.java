package com.axonactive.jpa.entity;

import com.axonactive.jpa.entity.enumerate.Location;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "health_insurance_location")
public class HealthInsuranceLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "location")
    @Enumerated(EnumType.STRING)
    private Location location;
}

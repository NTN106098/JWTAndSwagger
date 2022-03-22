package com.axonactive.jpa.entity;

import com.axonactive.jpa.entity.enumerate.AddressType;
import com.axonactive.jpa.entity.enumerate.Location;
import com.axonactive.jpa.persistence.IEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "health_insurance")
public class HealthInsurance implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "address_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "health_insurance_location", referencedColumnName = "id")
    private HealthInsuranceLocation healthInsuranceLocation;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;
}

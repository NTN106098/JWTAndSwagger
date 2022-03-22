package com.axonactive.jpa.entity;

import com.axonactive.jpa.entity.enumerate.AddressType;
import com.axonactive.jpa.entity.enumerate.Location;
import com.axonactive.jpa.entity.enumerate.PostAddress;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.mapstruct.EnumMapping;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pre_address")
    private String preAddress;

    @Column(name = "post_address")
    @Enumerated(EnumType.STRING)
    private Location postAddress;

    @Column(name = "address_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

    public String getFullAddress(){
        return this.preAddress + ", " + this.postAddress;
    }
}

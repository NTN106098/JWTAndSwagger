package com.axonactive.jpa.service.impl;

import com.axonactive.jpa.controller.request.AddressRequest;
import com.axonactive.jpa.entity.Address;
import com.axonactive.jpa.entity.Employee;
import com.axonactive.jpa.entity.enumerate.AddressType;
import com.axonactive.jpa.service.AddressService;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequestScoped
@Transactional
public class AddressServiceImpl implements AddressService {

    @PersistenceContext(unitName = "jpa")
    EntityManager entityManager;

    @Override
    public List<Address> getAllAddressesByEmployeeId(int employeeId) {
        Query query = entityManager.createQuery("SELECT a FROM Address a WHERE a.employee.id = :employeeId");
        query.setParameter("employeeId", employeeId);
        return query.getResultList();
    }

    @Override
    public Address addAddress(AddressRequest addressRequest) {
        Address address = new Address();
        Employee employee = entityManager.find(Employee.class, addressRequest.getEmployeeId());
        if (Objects.nonNull(employee)){
            address.setAddressType(addressRequest.getAddressType());
            address.setPreAddress(addressRequest.getPreAddress());
            address.setPostAddress(addressRequest.getPostAddress());
            address.setEmployee(employee);
            entityManager.merge(address);
        }
        return address;
    }

    @Override
    public Address updateAddress(int employeeId, AddressRequest addressRequest) {
        List<Address> addresses = getAllAddressesByEmployeeId(employeeId);
        Address address = addresses.stream().filter(a -> a.getAddressType() == addressRequest.getAddressType()).collect(Collectors.toList()).get(0);
        address.setPreAddress(addressRequest.getPreAddress());
        address.setPostAddress(addressRequest.getPostAddress());
        entityManager.merge(address);
        return address;
    }

    @Override
    public void deleteAddress(int employeeId, AddressType addressType) {
        Address address = getAllAddressesByEmployeeId(employeeId).stream().filter(a -> a.getAddressType() == addressType).collect(Collectors.toList()).get(0);
        if (Objects.nonNull(address)){
            entityManager.remove(address);
        }
    }
}

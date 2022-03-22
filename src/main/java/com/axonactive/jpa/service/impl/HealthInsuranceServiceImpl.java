//package com.axonactive.jpa.service.impl;
//
//import com.axonactive.jpa.controller.request.HealthInsuranceRequest;
//import com.axonactive.jpa.entity.Address;
//import com.axonactive.jpa.entity.Employee;
//import com.axonactive.jpa.entity.HealthInsurance;
//import com.axonactive.jpa.entity.HealthInsuranceLocation;
//import com.axonactive.jpa.persistence.AbstractCRUDBean;
//import com.axonactive.jpa.persistence.PersistenceService;
//import com.axonactive.jpa.service.HealthInsuranceService;
//import com.axonactive.jpa.service.dto.HealthInsuranceDTO;
//import com.axonactive.jpa.service.mapper.HealthInsuranceMapper;
//
//import javax.enterprise.context.RequestScoped;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.transaction.Transactional;
//import java.util.List;
//import java.util.Locale;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@RequestScoped
//@Transactional
//public class HealthInsuranceServiceImpl extends AbstractCRUDBean<HealthInsurance> {
//
//    @Inject
//    PersistenceService<HealthInsurance> persistenceService;
//
////    @Override
////    public List<HealthInsuranceDTO> getHealthInsuranceDTOByEmployeeId(int employeeId) {
////        Query query = entityManager.createQuery("SELECT h from HealthInsurance h WHERE h.employee.id = :employeeId");
////        query.setParameter("employeeId", employeeId);
////        List<HealthInsurance> healthInsurances = query.getResultList();
////        Employee employee = entityManager.find(Employee.class, employeeId);
////        return healthInsurances.stream().map(healthInsurance -> {
////            try {
////                HealthInsuranceDTO healthInsuranceDTO = healthInsuranceMapper.healthInsuranceToHealthInsuranceDTO(healthInsurance);
////                healthInsuranceDTO.setEmployeeName(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
////                healthInsuranceDTO.setYearOfBirth(employee.getDateOfBirth().getYear());
////                healthInsuranceDTO.setLocation(healthInsurance.getHealthInsuranceLocation().getLocation());
////                Query findAddress = entityManager.createQuery("SELECT a FROM Address a WHERE a.employee.id = :employeeId AND a.addressType = :addressType");
////                findAddress.setParameter("employeeId", employeeId);
////                findAddress.setParameter("addressType", healthInsurance.getAddressType());
////                Address address = (Address) findAddress.getSingleResult();
////                healthInsuranceDTO.setFullAddress(address.getFullAddress());
////                return healthInsuranceDTO;
////            } catch (NoResultException e) {
////                HealthInsuranceDTO healthInsuranceDTO = healthInsuranceMapper.healthInsuranceToHealthInsuranceDTO(healthInsurance);
////                healthInsuranceDTO.setEmployeeName(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
////                healthInsuranceDTO.setYearOfBirth(employee.getDateOfBirth().getYear());
////                healthInsuranceDTO.setLocation(healthInsurance.getHealthInsuranceLocation().getLocation());
////                return healthInsuranceDTO;
////            }
////        }).collect(Collectors.toList());
////    }
////
////    @Override
////    public List<HealthInsuranceDTO> getAllHealthInsurance() {
////        Query query = entityManager.createQuery("SELECT h FROM HealthInsurance h");
////        List<HealthInsurance> healthInsurances = query.getResultList();
////        return healthInsurances.stream().map(healthInsurance -> {
////           try {
////               HealthInsuranceDTO healthInsuranceDTO = healthInsuranceMapper.healthInsuranceToHealthInsuranceDTO(healthInsurance);
////               Employee employee = entityManager.find(Employee.class, healthInsurance.getEmployee().getId());
////               healthInsuranceDTO.setEmployeeName(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
////               healthInsuranceDTO.setYearOfBirth(employee.getDateOfBirth().getYear());
////               healthInsuranceDTO.setLocation(healthInsurance.getHealthInsuranceLocation().getLocation());
////               Query findAddress = entityManager.createQuery("SELECT a FROM Address a WHERE a.employee.id = :employeeId AND a.addressType = :addressType");
////               findAddress.setParameter("employeeId", employee.getId());
////               findAddress.setParameter("addressType", (healthInsurance).getAddressType());
////               Address address = (Address) findAddress.getSingleResult();
////               healthInsuranceDTO.setFullAddress(address.getFullAddress());
////               return healthInsuranceDTO;
////           } catch (NoResultException e) {
////               HealthInsuranceDTO healthInsuranceDTO = healthInsuranceMapper.healthInsuranceToHealthInsuranceDTO(healthInsurance);
////               Employee employee = entityManager.find(Employee.class, healthInsurance.getEmployee().getId());
////               healthInsuranceDTO.setEmployeeName(employee.getFirstName() + " " + employee.getMiddleName() + " " + employee.getLastName());
////               healthInsuranceDTO.setYearOfBirth(employee.getDateOfBirth().getYear());
////               healthInsuranceDTO.setLocation(healthInsurance.getHealthInsuranceLocation().getLocation());
////               return healthInsuranceDTO;
////           }
////        }).collect(Collectors.toList());
////    }
//    public List<HealthInsurance>getAllHealthInsurance(){
//        return persistenceService.createQuery("SELECT h FROM HealthInsurance h").getResultList();
//    }
////
////    @Override
////    public HealthInsurance addHealthInsurance(int employeeId, HealthInsuranceRequest healthInsuranceRequest) {
////        HealthInsurance healthInsurance = new HealthInsurance();
////        healthInsurance.setEmployee(entityManager.find(Employee.class, employeeId));
////        healthInsurance.setHealthInsuranceLocation(entityManager.find(HealthInsuranceLocation.class, healthInsuranceRequest.getHealthInsuranceLocationId()));
////        healthInsurance.setAddressType(healthInsuranceRequest.getAddressType());
////        healthInsurance.setCode(healthInsuranceRequest.getCode());
////        healthInsurance.setExpirationDate(healthInsuranceRequest.getExpirationDate());
////        entityManager.persist(healthInsurance);
////        return healthInsurance;
////    }
////
////    @Override
////    public HealthInsurance updateHealthInsurance(String code, HealthInsuranceRequest healthInsuranceRequest) {
////        Query query = entityManager.createQuery("SELECT h FROM HealthInsurance h WHERE h.code = :code");
////        query.setParameter("code", code);
////        HealthInsurance healthInsurance = (HealthInsurance) query.getSingleResult();
////        healthInsurance.setHealthInsuranceLocation(entityManager.find(HealthInsuranceLocation.class, healthInsuranceRequest.getHealthInsuranceLocationId()));
////        healthInsurance.setCode(healthInsuranceRequest.getCode());
////        healthInsurance.setAddressType(healthInsuranceRequest.getAddressType());
////        healthInsurance.setExpirationDate(healthInsuranceRequest.getExpirationDate());
////        entityManager.merge(healthInsurance);
////        return healthInsurance;
////    }
////
////    @Override
////    public void deleteHealthInsurance(String code) {
////        Query query = entityManager.createQuery("SELECT h FROM HealthInsurance h WHERE h.code = :code");
////        query.setParameter("code", code);
////        HealthInsurance healthInsurance = (HealthInsurance) query.getSingleResult();
////        if (Objects.nonNull(healthInsurance)) {
////            entityManager.remove(healthInsurance);
////        }
////    }
////
////    @Override
////    public List<HealthInsurance> getAllHealthInsuranceDTOByEmployeeName(String employeeName) {
////        Query query = entityManager.createQuery("SELECT h FROM HealthInsurance h WHERE h.employee.firstName = :employeeName");
////        query.setParameter("employeeName", employeeName);
////        List<HealthInsurance> healthInsurances = query.getResultList();
////        return healthInsurances;
////    }
//
//    @Override
//    protected PersistenceService<HealthInsurance> getPersistenceService() {
//        return null;
//    }
//}

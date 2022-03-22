package com.axonactive.jpa.service.impl;

import com.axonactive.jpa.controller.request.DepartmentRequest;
import com.axonactive.jpa.entity.Department;
import com.axonactive.jpa.entity.Employee;
import com.axonactive.jpa.persistence.AbstractCRUDBean;
import com.axonactive.jpa.persistence.PersistenceService;
import com.axonactive.jpa.service.DepartmentService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RequestScoped
@Transactional
public class DepartmentServiceImpl extends AbstractCRUDBean<Department> implements DepartmentService {

    @Inject
    PersistenceService<Department> persistenceService;
    @PersistenceContext(unitName = "jpa")
    EntityManager entityManager;
    @Override
    protected PersistenceService<Department> getPersistenceService() {
        return persistenceService;
    }

    @Override
    public List<Department> getAllDepartment() {
        return entityManager.createQuery("from Department", Department.class).getResultList();
    }

    @Override
    public Department getDepartmentById(int id) {
        return findById(id);

    }

    @Override
    public Department addDepartment(DepartmentRequest departmentRequest) {
        Department department = new Department();
        department.setName(departmentRequest.getName());
        department.setStartDate(departmentRequest.getStartDate());
//        entityManager.persist(department);
        save(department);
        return department;
    }

    @Override
    public void deleteDepartment(int id) {
        //        Department department = getDepartmentById(id);
//        if (Objects.nonNull(department)) {
//            entityManager.remove(department);

        Department department = findById(id);
        if (Objects.nonNull(department)) {
            remove(id);
        }
    }

    @Override
    public Department updateDepartment(int id, DepartmentRequest departmentRequest) {
        Department department = findById(id);
        department.setName(departmentRequest.getName());
        department.setStartDate(departmentRequest.getStartDate());
//        entityManager.merge(department);
        update(department);
        return department;
    }

//    @Override
//    public List<Employee> getEmployeesWorkInDept(int year) {
//        return null;
//    }
//
//    @PersistenceContext(unitName = "jpa")
//    EntityManager entityManager;
//
//    @Override
//    public Department getDepartmentById(int id) {
//        return entityManager.find(Department.class, id);
//    }
//
//    @Override
//    public List<Department> getAllDepartment() {
//        return entityManager.createQuery("from Department", Department.class).getResultList();
//    }
//
//    @Override
//    public Department addDepartment(DepartmentRequest departmentRequest) {
//        Department department = new Department();
//        department.setName(departmentRequest.getName());
//        department.setStartDate(departmentRequest.getStartDate());
//        entityManager.persist(department);
//        return department;
//    }
//
//    @Override
//    public void deleteDepartment(int id) {
//        Department department = getDepartmentById(id);
//        if (Objects.nonNull(department)) {
//            entityManager.remove(department);
//        }
//    }
//
//    @Override
//    public Department updateDepartment(int id, DepartmentRequest departmentRequest) {
//        Department department = getDepartmentById(id);
//        department.setName(departmentRequest.getName());
//        department.setStartDate(departmentRequest.getStartDate());
//        entityManager.merge(department);
//        return department;
//    }
//
//    @Override
//    public List<Employee> getEmployeesWorkInDept(int year) {
//        TypedQuery<Employee> namedQuery = entityManager.createNamedQuery(Employee.GET_EMPLOYEE_BELONG_TO_DEPT_START_IN_YYYY, Employee.class);
//        namedQuery.setParameter("deptStartDate", LocalDate.of(year, 1, 1));
//        namedQuery.setParameter("deptEndDate", LocalDate.of(year, 12, 31));
//        return namedQuery.getResultList();
//    }


}

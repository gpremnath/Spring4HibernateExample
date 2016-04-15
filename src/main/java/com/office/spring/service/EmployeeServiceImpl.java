package com.office.spring.service;

/**
 * Created by totient on 30/7/15.
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.office.spring.dao.EmployeeDao;
import com.office.spring.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao dao;

    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }

    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

    public void deleteEmployeeBySsn(String ssn) {
        dao.deleteEmployeeBySsn(ssn);
    }

    public Employee findBySsn(String ssn) {
        return dao.findBySsn(ssn);
    }

    public void updateEmployee(Employee employee){
        dao.updateEmployee(employee);
    }

    public void testTransaction() {dao.testTransaction();}

    public Employee findEmployeeBySsn(String ssn) {
        return dao.findEmployeeBySsn(ssn);
    }

    public boolean isEmployeeSsnUnique(Integer id, String ssn) {
        Employee employee = findEmployeeBySsn(ssn);
        return ( employee == null || ((id != null) && (employee.getId() == id)));
    }

}
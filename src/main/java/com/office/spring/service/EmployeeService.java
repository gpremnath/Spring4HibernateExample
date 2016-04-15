package com.office.spring.service;

/**
 * Created by totient on 30/7/15.
 */
import java.util.List;

import com.office.spring.model.Employee;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployeeBySsn(String ssn);

    Employee findBySsn(String ssn);

    void updateEmployee(Employee employee);

    public boolean isEmployeeSsnUnique(Integer id, String ssn);

    Employee findEmployeeBySsn(String ssn);

    void testTransaction();
}
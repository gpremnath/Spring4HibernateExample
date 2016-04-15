package com.office.spring.dao;

/**
 * Created by totient on 30/7/15.
 */
import java.util.List;

import com.office.spring.model.Employee;

public interface EmployeeDao {

    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployeeBySsn(String ssn);

    Employee findBySsn(String ssn);

    void updateEmployee(Employee employee);

    Employee findEmployeeBySsn(String ssn);
    void testTransaction();
}
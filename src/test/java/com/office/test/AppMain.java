package com.office.test;

/**
 * Created by totient on 30/7/15.
 */
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.office.spring.dao.EmployeeDao;
import com.office.spring.model.Team;
import com.office.spring.service.TeamService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.office.spring.configuration.AppConfig;
import com.office.spring.model.Employee;
import com.office.spring.service.EmployeeService;

public class AppMain {

    //@Test
    public void InsertEmployee (){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        EmployeeService service = (EmployeeService) context.getBean("employeeService");
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        /*
         * Create Employee1
         */
        Employee employee1 = new Employee();
        employee1.setName("Han Yenn");
        employee1.setJoiningDate(new Date());
        employee1.setSalary(new BigDecimal(10000));
        employee1.setSsn("ssn00000001");

        /*
         * Create Employee2
         */
        Employee employee2 = new Employee();
        employee2.setName("Dan Thomas");
        employee2.setJoiningDate(new Date());
        employee2.setSalary(new BigDecimal(20000));
        employee2.setSsn("ssn00000002");

        /*
         * Persist both Employees
         */
        service.saveEmployee(employee1);
        service.saveEmployee(employee2);

        /*
         * Get all employees list from database
         */
        List<Employee> employees = service.findAllEmployees();
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        /*
         * delete an employee
         */
        service.deleteEmployeeBySsn("ssn00000002");

        /*
         * update an employee
         */

        Employee employee = service.findBySsn("ssn00000001");
        employee.setSalary(new BigDecimal(50000));
        service.updateEmployee(employee);

        /*
         * Get all employees list from database
         */
        List<Employee> employeeList = service.findAllEmployees();
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        service.testTransaction();
        context.close();
       }

    @Test
    public void testBidirectionalOneToManyOrManyToOne (){
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //EmployeeService service = (EmployeeService) context.getBean("employeeService");
        TeamService teamService=(TeamService)context.getBean("teamService");
        /*
         * Create Employee1
         */
        Employee employee1 = new Employee();
        employee1.setName("Mike Jason");
        employee1.setJoiningDate(new Date());
        employee1.setSalary(new BigDecimal(10000));
        employee1.setSsn("ssn00000005");

        /*
         * Create Employee2
         */
        Employee employee2 = new Employee();
        employee2.setName("Sean Thomas");
        employee2.setJoiningDate(new Date());
        employee2.setSalary(new BigDecimal(20000));
        employee2.setSsn("ssn00000004");

        Team team = new Team();
        team.setName("Database Team");
        Set<Employee> employees = new HashSet<Employee>();

        employees.add(employee1);
        employees.add(employee2);

        employee1.setGroup(team);
        employee2.setGroup(team);
        team.setEmployees(employees);
        teamService.saveTeam(team);


        context.close();
    }


    @Test
    public void testDeleteTeamById(){

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        TeamService teamService=(TeamService)context.getBean("teamService");
        teamService.deleteTeamByName("Database Team");
        context.close();
    }
}
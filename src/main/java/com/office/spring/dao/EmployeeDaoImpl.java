package com.office.spring.dao;

/**
 * Created by totient on 30/7/15.
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;

import com.office.spring.model.Employee;



@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer,Employee > implements EmployeeDao{

    public void saveEmployee(Employee employee) {
        persist(employee);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }

    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }


    public Employee findBySsn(String ssn){
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn",ssn));
        return (Employee) criteria.uniqueResult();
    }

    public void updateEmployee(Employee employee){
        getSession().update(employee);
    }


    public Employee findEmployeeBySsn(String ssn) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Employee) criteria.uniqueResult();
    }


    public void testTransaction(){
       /* Session session = getSession();
        session.doWork(
                (connection)->{

                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEE");


                }
        );
*/

    }

}
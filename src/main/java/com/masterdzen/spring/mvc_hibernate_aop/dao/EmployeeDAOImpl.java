package com.masterdzen.spring.mvc_hibernate_aop.dao;

import com.masterdzen.spring.mvc_hibernate_aop.entity.Employee;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Employee ", Employee.class);
       return (List<Employee>) query.getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        sessionFactory.getCurrentSession().persist(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }
}

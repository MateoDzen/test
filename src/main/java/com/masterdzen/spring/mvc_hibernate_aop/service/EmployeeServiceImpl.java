package com.masterdzen.spring.mvc_hibernate_aop.service;

import com.masterdzen.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.masterdzen.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO dao;

    public EmployeeServiceImpl(EmployeeDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    @Override
    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return dao.getEmployee(id);
    }
}

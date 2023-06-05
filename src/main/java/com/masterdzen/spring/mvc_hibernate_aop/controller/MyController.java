package com.masterdzen.spring.mvc_hibernate_aop.controller;

import com.masterdzen.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.masterdzen.spring.mvc_hibernate_aop.dao.EmployeeDAOImpl;
import com.masterdzen.spring.mvc_hibernate_aop.entity.Employee;
import com.masterdzen.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    private EmployeeService service;

    public MyController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = service.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("newEmp", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("newEmp") Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {
        Employee employee = service.getEmployee(id);
        model.addAttribute("newEmp", employee);
        return "employee-info";
    }
}

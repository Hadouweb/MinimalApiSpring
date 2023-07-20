package com.hr.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hr.api.model.Employee;
import com.hr.api.service.EmployeeService;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees/create/")
    public Employee creatEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees/update/{id}")
    public Employee updatEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Optional<Employee> em = employeeService.getEmployee(id);
        if (!em.isPresent())
            return null;

        Employee currentEmployee = em.get();

        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        String mail = employee.getMail();
        String password = employee.getPassword();

        if (firstName != null)
            currentEmployee.setFirstName(firstName);
        if (lastName != null)
            currentEmployee.setFirstName(lastName);
        if (mail != null)
            currentEmployee.setMail(mail);
        if (password != null)
            currentEmployee.setPassword(password);

        employeeService.saveEmployee(currentEmployee);
        return currentEmployee;
    }

    @DeleteMapping("/employees/remove/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}

package gr.codehub.s101.controller;

import gr.codehub.s101.domain.Employee;
import gr.codehub.s101.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            employee = new Employee();
            employee.setName("NO EMPLOYEE FOUND WITH THIS ID");
        }
        return employee;
    }
}

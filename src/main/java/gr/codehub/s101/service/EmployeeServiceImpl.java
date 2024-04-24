package gr.codehub.s101.service;

import gr.codehub.s101.domain.Employee;
import gr.codehub.s101.repository.CustomerDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private CustomerDatabase customerDatabase;

    @Override
    public Employee getEmployee(int id) {
        try {
            customerDatabase.getConnection();
            Employee employee = customerDatabase.getEmployee(id);
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}

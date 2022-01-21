package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;  // universally unique identifier

@Service  
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class); // activating the logger

    @Autowired
    private EmployeeRepository employeeRepository; // setting the employeerepository variable as a constant 

    @Override
    public Employee create(Employee employee) {  // defining the logic for the create functionality when called to create an employee.
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());  // creating an employee and setting the id to a random identifier and converting that identifier to a string.
        employeeRepository.insert(employee);  // inserting this employee with a UUID into the employee repository.

        return employee;   // returning an employee.
    }

    @Override
    public Employee read(String id) {  // creating the functionality to read the id and get an employee by id now as well. 
        LOG.debug("Creating employee with id [{}]", id);  // checking to ensure the employee was created.

        Employee employee = employeeRepository.findByEmployeeId(id);  // using the findEmployeeId method taking in an id to search the employee repo for the specific employee and setting that employee equal to employee.

        // a catch function that if employee is not found (null) will throw a runtime exception that will claim the employee id entered is not valid.
        if (employee == null) {  
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;  // returns the employee 
    }

    @Override
    public Employee update(Employee employee) {  // creating the functionality to update an employee by allowing the information to be saved (persisted) to the employee repository. (compensation only).
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);  // will save an updated employee to the employee repository.
    }
}

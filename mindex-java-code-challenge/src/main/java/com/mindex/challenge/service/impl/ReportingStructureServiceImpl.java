package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;


// importing list functionality into the reporting structure to allow it to read lists.
import java.util.List;


// importing the simple logging facade 4 java to allow for console.log debugging functionality.
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

// importing the spring framework beans factory to allow autowiring and servicing which will be autodetected and 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // creating a service file to let spring know this is a file containing useful logic.
public class ReportingStructureServiceImpl implements ReportingStructureService {

	@Autowired  // A springbook keyword used to let spring know to run this logic automatically 
	private EmployeeRepository employeeRepository;
	

	// Creating an encapsulated Logger that will be able to access the reportingstructureservice impl class.
	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);
	
	 

	@Override // @Override used to display any signature errors or compile errors when running.
	public ReportingStructure read(String employeeId) {  // setting a global class that will take the employeeid as a parameter
		LOG.debug("Getting total reports of employee [{}]", employeeId);  // logging the employee ID's that are directly reporting to the employee searched in the console.
		Employee employee = employeeRepository.findByEmployeeId(employeeId); // Using the findemployeeid method (which takes employeeid as a parameter) and runs this method in the employee repository.
		ReportingStructure reportingStructure = new ReportingStructure();  // Gets the reporting structure anc creates a new instance of this structure 
		reportingStructure.setEmployee(employee); // in the newly declared reportingStructure, we are going to access the set employee method and insert an employee as a parameter.
		 // we also instantiate the numOfReports method and recusively call the getNumberofReports method with an employee as an instance.
		 // this will take an each employee (and their reports) and set automatically calculate that total number in the reporting structure
		reportingStructure.setNumOfReports(getNumberOfReports(employee));

	// this will return the reporting structure displaying the total number of reports without persisting the data.
		return reportingStructure;
	}
	

	// the encapsulated function in charge of recursively calculating the number of direct reports.

	private int getNumberOfReports(Employee employee) {  // declaring a class getNumberOfReports and taking an employee (defined above) as a parameter.
		int totalReports = 0;  // setting an initial variable of totalReports to 0
		List<Employee> empDirectReports = employee.getDirectReports();  // establishing a list containing employee's. Creating a variable that will call the recursive function (getdirectReports) for each employee listed.
		if(empDirectReports == null) {  // establishing the base case if eDR returns null, then the total number of reports will be returned.
			return totalReports; //returning totalReports if the base case is completed.
		}
		for(Employee e : empDirectReports) {  // instatinating a for loop that will iterate throuugh each employee (e) and see if they contain direct reports.
		
			// We are finding in the employeeRepository the employee who's ID was searched. For this employee, we are 
			// iterating through each employee directly reporting to the searched employee (e) and getting and returning that employee's id as well.
			Employee reportEmployee = employeeRepository.findByEmployeeId(e.getEmployeeId());  
			totalReports++;  // for each employee directly reporting, we are adding one to the number of total reports.
			totalReports += getNumberOfReports(reportEmployee);  // recursively calling this function and accepting a report employee as to find any further directly reporting employee's. 
		}
		
		return totalReports; // returning the total number of reports.
		
	}
}
package com.mindex.challenge.data;

	// declaring a class ReportingStructure
public class ReportingStructure {
	private Employee employee; // will hold the value for the employee
	private int numOfReports;  // will hold the number of employee reports
	
	// will be the initial constructor
	public ReportingStructure() {
		
	}
	
	public ReportingStructure(Employee employee, int numOfReports) {
		this.setEmployee(employee); // getting the employee from the data and allowing it to be accessed by using the employee variable/keyword
		this.setNumOfReports(numOfReports); // getting the number of reports from the data and allowing it to be accessed by the numOfReports variable.
	}

	public Employee getEmployee() {  // creating a function that when invoked will return an employee.
		return employee;
	}

	public void setEmployee(Employee employee) {  // this method does not return anything, it takes "this" from the global setting and attaches it to the employee keyword.
		this.employee = employee;
	}

	public int getNumOfReports() {  // creating a function that takes the integer primitive value and will return a number of reports.
		return numOfReports;
	}

	public void setNumOfReports(int numOfReports) { // creating a function that will not return anything, but set the keyword numOfReports to the value for the number of reports, allowing this value to be accessed and shown.
		this.numOfReports = numOfReports;
	}
}
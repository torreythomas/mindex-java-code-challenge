package com.mindex.challenge.data;

	
public class ReportingStructure {
	private Employee employee; 
	private int numOfReports;  
	
	
	public ReportingStructure() {
		
	}
	
	public ReportingStructure(Employee employee, int numOfReports) {
		this.setEmployee(employee);
		this.setNumOfReports(numOfReports);
	}

	public Employee getEmployee() { 
		return employee;
	}

	public void setEmployee(Employee employee) {  
		this.employee = employee;
	}

	public int getNumOfReports() {  
		return numOfReports;
	}

	public void setNumOfReports(int numOfReports) { 
		this.numOfReports = numOfReports;
	}
}
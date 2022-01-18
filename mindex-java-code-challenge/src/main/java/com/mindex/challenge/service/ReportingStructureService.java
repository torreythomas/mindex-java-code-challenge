package com.mindex.challenge.service;
import com.mindex.challenge.data.ReportingStructure;  

// definining a reporting structure service class 
public interface ReportingStructureService {  

// the reporting structure will read and return the employee ID.
	ReportingStructure read(String employeeId);  
}
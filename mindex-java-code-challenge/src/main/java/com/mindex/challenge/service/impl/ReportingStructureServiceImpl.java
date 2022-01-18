package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);
	
	@Override
	public ReportingStructure read(String employeeId) {
		LOG.debug("Getting total reports of employee [{}]", employeeId);
		Employee employee = employeeRepository.findByEmployeeId(employeeId);
		ReportingStructure reportingStructure = new ReportingStructure();
		reportingStructure.setEmployee(employee);
		reportingStructure.setNumOfReports(getNumberOfReports(employee));
		return reportingStructure;
	}
	
	private int getNumberOfReports(Employee employee) {
		int totalReports = 0;
		List<Employee> empDirectReports = employee.getDirectReports();
		if(empDirectReports == null) {
			return totalReports;
		}
		for(Employee e : empDirectReports) {
			Employee reportEmployee = employeeRepository.findByEmployeeId(e.getEmployeeId());
			totalReports++;
			totalReports += getNumberOfReports(reportEmployee);
		}
		
		return totalReports;
		
	}
}
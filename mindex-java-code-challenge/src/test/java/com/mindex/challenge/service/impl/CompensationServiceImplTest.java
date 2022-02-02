package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.dao.*;
import com.mindex.challenge.service.CompensationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {
	
	private String createCompUrl;
	private String readCompUrl;
	
	@Autowired
	private CompensationService compensationService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private Employee testEmployee;
	
	@Before
	public void setup() {
		
		createCompUrl = "http://localhost:" + port + "/compensation";
		readCompUrl = "http://localhost:" + port + "/compensation/{id}";
		
	}
	
	@Test
	public void testCreateRead() {
		Compensation testCompensation = new Compensation();
		testEmployee = employeeRepository.findByEmployeeId("03aa1462-ffa9-4978-901b-7c001562cf6f");
		String testEmpId = testEmployee.getEmployeeId();
		Date testDate = new Date();
		testCompensation.setEmployee(testEmployee);
		testCompensation.setSalary(223.57);
		testCompensation.setEffectiveDate(testDate);
		
		//create test
		Compensation createdCompensation = restTemplate.postForEntity(createCompUrl, testCompensation, Compensation.class).getBody();
		assertNotNull(createdCompensation.getEmployee());
		assertNotNull(createdCompensation.getSalary());
		assertNotNull(creasstedCompensation.getEffectiveDate());
		
		//read test
		Compensation readCompensation = restTemplate.getForEntity(readCompUrl, Compensation.class, testEmpId).getBody();
		assertNotNull(readCompensation);
		
		// is compensation set?
		assertEquals(testCompensation.getSalary(), readCompensation.getSalary());
	}
}
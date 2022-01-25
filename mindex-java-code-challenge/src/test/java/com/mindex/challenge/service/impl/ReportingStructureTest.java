package com.mindex.challenge.service.impl;


import com.mindex.challenge.data.ReportingStructure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReportingStructureServiceImplTest {
	private String reportStructureReadUrl;
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Before
	public void setup() {
		reportStructureReadUrl = "http://localhost:" + port + "/reportingstructure/{id}";
	}
	@Test
	public void testRead() {
		ReportingStructure testStructure = new ReportingStructure();
		String testId = "03aa1462-ffa9-4978-901b-7c001562cf6f";
		String testIdTwo = "16a596ae-edd3-4847-99fe-c4518e82c86f";
		
		testStructure = restTemplate.getForEntity(reportStructureReadUrl, ReportingStructure.class, testId).getBody();
		assertNotNull(testStructure);
		
		// Ringo = 2
		assertEquals(testStructure.getNumOfReports(), 2);
		
		testStructure = restTemplate.getForEntity(reportStructureReadUrl, ReportingStructure.class, testIdTwo).getBody();
		assertNotNull(testStructure);
	
		// Lennon = 4
		assertEquals(testStructure.getNumOfReports(), 4);
		
	}
}
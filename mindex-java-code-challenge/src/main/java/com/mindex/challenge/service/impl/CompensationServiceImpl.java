package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompensationServiceImpl implements CompensationService {  
	private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);
	
	@Autowired
	private CompensationRepository compensationRepository;
	 

	// the code sample below is creating a function that will accept compensation as a parameter and create a new
	// field for compensation and inserting this result into the compensation repository, allowing this to be persisted.
	@Override
	public Compensation create(Compensation compensation) {
		LOG.debug("Creating compensation [{}]", compensation);
	    compensationRepository.insert(compensation);

	    return compensation;
	   }

	   // Creating another function that will read an id passed as a parameter and this will allow an employee's compensation
	   // to be read when the employee is being searched by id, therefore again, persisting the information. 

	@Override
	public Compensation read(String id) {
		LOG.debug("Getting compensation of employee [{}]", id);
		Compensation compensation = compensationRepository.findCompByEmployeeEmployeeId(id);
		if(compensation == null) {
			throw new RuntimeException("Compensation information not found for employeeId: " + id);
		}
		
		return compensation;
	}
	
}
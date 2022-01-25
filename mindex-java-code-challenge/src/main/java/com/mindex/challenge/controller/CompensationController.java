package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {
	private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);


    // Automatically updating and occupying the code with a new compensation field and inserting a value entered via a path entry
    @Autowired
    private CompensationService compensationService;
    
    @PostMapping("/compensation")
    public Compensation create(@RequestBody Compensation compensation) {
        LOG.debug("Received compensationService create request for [{}]", compensation);

        return compensationService.create(compensation);
    }
    
    @GetMapping("/compensation/{id}")
    public Compensation read(@PathVariable String id) {
    	LOG.debug("Received compensationService read request for employeeId [{}]", id);
    	
    	return compensationService.read(id);
    }
	

}
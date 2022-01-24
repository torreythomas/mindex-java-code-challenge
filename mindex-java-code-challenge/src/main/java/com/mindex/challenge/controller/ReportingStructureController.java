package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// will return data written into the response body.
@RestController  
public class ReportingStructureController {

    // Getting the logger and allowing it to read the ReportingStructureController class.
	private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureController.class); 


    // Alerts Spring to automatically configure the proper paths and scans for classes, creating beans.
    @Autowired 
    private ReportingStructureService reportingStructureService;
    
    // ensures that the HTTP GET requests are mapped to the ReportingStructure method.
    @GetMapping("/reportingstructure/{id}")

    // Creates a path variable that will accept an employee as entry.
    public ReportingStructure read(@PathVariable String id) {

        // using the debug setting to ensure that a create request was recieved for an employee ID.
        LOG.debug("Received reportingStructure create request for employeeId [{}]", id);

        return reportingStructureService.read(id);
    }
    

}
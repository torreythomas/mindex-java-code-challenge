package com.mindex.challenge.service;

// importing the compensation data file.
import com.mindex.challenge.data.Compensation;

// creating the crud functionality for the compensation service.
public interface CompensationService {
    Compensation create(Compensation compensation);  
    Compensation read(String id); 
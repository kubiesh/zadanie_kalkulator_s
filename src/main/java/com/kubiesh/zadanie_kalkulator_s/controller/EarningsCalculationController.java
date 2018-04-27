package com.kubiesh.zadanie_kalkulator_s.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EarningsCalculationController {
	
	@GetMapping("/{countryID}/{dailyRate}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<BigDecimal> calculateEarnings
	(
			@PathVariable String countryID,
			@PathVariable BigDecimal dailyRate
	) 
	{
		
		
				return null;
	}
	
}

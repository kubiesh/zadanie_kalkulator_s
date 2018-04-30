package com.kubiesh.zadanie_kalkulator_s.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kubiesh.zadanie_kalkulator_s.dao.CountryDAO_json;
import com.kubiesh.zadanie_kalkulator_s.dao.ICountryDAO;
import com.kubiesh.zadanie_kalkulator_s.entities.Country;
import com.kubiesh.zadanie_kalkulator_s.services.FinalEarningsCalculator;
import com.kubiesh.zadanie_kalkulator_s.services.LocalEarningsCalculator;

@RestController
public class EarningsCalculationController {
	
	
	private ICountryDAO countryDAO;
	@Autowired
	private LocalEarningsCalculator localEarningsCalculator;
	private FinalEarningsCalculator finalEarningsCalculator;
	
	private String countryID;
	private BigDecimal dailyRate;
	private Country selectedCountry;
	
	@Autowired
	public EarningsCalculationController(ICountryDAO countryDAO, FinalEarningsCalculator finalEarningsCalculator) {
		this.countryDAO=countryDAO;
		this.finalEarningsCalculator=finalEarningsCalculator;
	}
	
	@GetMapping("/api/{countryID}/{dailyRate}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<BigDecimal> calculateEarnings
	(
			@PathVariable String countryID,
			@PathVariable BigDecimal dailyRate
	) 
	{
		this.countryID=countryID;
		this.dailyRate=dailyRate;
		
		if (!validate()) {
		return new ResponseEntity<BigDecimal>(new BigDecimal(0),HttpStatus.BAD_REQUEST);
		}
		BigDecimal localEarnings = localEarningsCalculator.getLocalEarnings(selectedCountry,dailyRate,countryDAO.getWorkDays());
		BigDecimal finalEarnings = finalEarningsCalculator.getFinalEarnings(selectedCountry,localEarnings);
		
		return new ResponseEntity<BigDecimal>(finalEarnings,HttpStatus.OK);
	}
	private Boolean validate() {
		return validateCountry() && validateDailyRate();
	}
	
	private Boolean validateCountry() {
		try {
			selectedCountry = countryDAO.getCountry(countryID);
			}
			catch (Exception e) {
				return false;
			}
		return true;
	}
	private Boolean validateDailyRate() {
		if(dailyRate.doubleValue()>(double)0) {
			return true;
		}
		return false;
		
	}
}

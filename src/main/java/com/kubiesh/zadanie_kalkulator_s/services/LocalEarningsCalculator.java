package com.kubiesh.zadanie_kalkulator_s.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.kubiesh.zadanie_kalkulator_s.entities.Country;

@PropertySource("classpath:LocalEarningsCalculator.properties")
public class LocalEarningsCalculator {
	
	private Country countryData;
	private BigDecimal dailyRate;
	@Value("${dataFilePath}") 
	private String dataFilePath;

	public LocalEarningsCalculator(String currencyCode, BigDecimal dailyRate) {
		
	}
	
	private void fillCountryData(String currencyCode) {
		
	}
}

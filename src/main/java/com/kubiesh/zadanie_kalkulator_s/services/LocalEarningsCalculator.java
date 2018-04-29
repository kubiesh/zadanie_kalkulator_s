package com.kubiesh.zadanie_kalkulator_s.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.kubiesh.zadanie_kalkulator_s.entities.Country;

@Service
public class LocalEarningsCalculator {
	
	private Country countryData;
	private BigDecimal dailyRate;
	private int workDays;

	public LocalEarningsCalculator(Country countryData, BigDecimal dailyRate, int workDays) {
		this.countryData=countryData;
		this.dailyRate=dailyRate;
		this.workDays=workDays;
	}
	
	public BigDecimal getLocalEarnings() {
		/* (dailyRate*workDays)*(1-taxRate)-fixedCosts */
		BigDecimal localEarnings = dailyRate.multiply(new BigDecimal(workDays));
		BigDecimal netPercentage = new BigDecimal(1).subtract(countryData.getTaxRate());
		localEarnings=localEarnings.multiply(netPercentage);
		localEarnings=localEarnings.subtract(countryData.getFixedCosts());
		
		localEarnings=localEarnings.setScale(2,RoundingMode.HALF_EVEN); //i.e. 10.50 instead of 10.5000000011
		return localEarnings;
	}
}

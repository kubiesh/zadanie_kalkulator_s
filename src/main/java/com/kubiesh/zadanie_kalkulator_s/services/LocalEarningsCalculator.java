package com.kubiesh.zadanie_kalkulator_s.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.kubiesh.zadanie_kalkulator_s.entities.Country;


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
		
		BigDecimal localEarnings = dailyRate;
		
		
		//TO DO: whole function after finished CountryDAO
	}
}

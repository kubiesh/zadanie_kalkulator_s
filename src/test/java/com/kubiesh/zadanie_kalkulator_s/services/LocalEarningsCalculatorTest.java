package com.kubiesh.zadanie_kalkulator_s.services;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import com.kubiesh.zadanie_kalkulator_s.entities.Country;

public class LocalEarningsCalculatorTest {
	
	private LocalEarningsCalculator localEarningsCalculator;
	private Country country;
	private BigDecimal dailyRate;
	private int workDays;
	
	@Before
	public void setup() {
		countrySetupPL();
		dailyRate=new BigDecimal(135.55);
		workDays=22;
		localEarningsCalculator = new LocalEarningsCalculator();
	}
	
	private void countrySetupPL() {
		country=new Country();
		country.setCountryID("PL");
		country.setCountryName("Poland");
		country.setCurrencyCode("PLN");
		country.setFixedCosts(new BigDecimal(1200));
		country.setTaxRate(new BigDecimal(0.19));
	}

	@Test
	public void testGetLocalEarnings() {
		BigDecimal expectedEarnings = new BigDecimal(1215.50).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal localEarnings = localEarningsCalculator.getLocalEarnings(country,dailyRate,workDays);
		assertEquals(expectedEarnings, localEarnings);
		
	}

}

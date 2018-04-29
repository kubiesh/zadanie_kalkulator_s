package com.kubiesh.zadanie_kalkulator_s.services;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import com.kubiesh.zadanie_kalkulator_s.currencyRateAPI.currencyRateAPITestStub;
import com.kubiesh.zadanie_kalkulator_s.entities.Country;

public class FinalEarningsCalculatorTest {
	
	private FinalEarningsCalculator finalEarningsCalculator;
	private Country country;
	private BigDecimal localEarnings;

	@Before
	public void setUp() throws Exception {
		finalEarningsCalculator = new FinalEarningsCalculator(new currencyRateAPITestStub());
		finalEarningsCalculator.finalCountryID="PL";
		countrySetupUK();
		localEarnings=new BigDecimal(1325.45);
	}

	private void countrySetupUK() {
		/* only countryID and currencyCode are important in this test */
		country=new Country();
		country.setCountryID("UK");
		country.setCountryName("United Kingdom");
		country.setCurrencyCode("GBP");
		country.setFixedCosts(new BigDecimal(600));
		country.setTaxRate(new BigDecimal(0.25));
	}
	
	private Country countrySetupPL() {
		Country country=new Country();
		country.setCountryID("PL");
		country.setCountryName("Poland");
		country.setCurrencyCode("PLN");
		country.setFixedCosts(new BigDecimal(1200));
		country.setTaxRate(new BigDecimal(0.19));
		return country;
	}

	@Test
	public void testGetFinalEarningsUK() {
		BigDecimal expectedEarnings = new BigDecimal(6412.394555).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal finalEarnings = finalEarningsCalculator.getFinalEarnings(country,localEarnings);
		assertEquals(expectedEarnings, finalEarnings);
	}
	@Test
	public void testGetFinalEarningsPL() {
		BigDecimal expectedEarnings = new BigDecimal(1325.45).setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal finalEarnings = finalEarningsCalculator.getFinalEarnings(countrySetupPL(),localEarnings);
		assertEquals(expectedEarnings, finalEarnings);
	}

}

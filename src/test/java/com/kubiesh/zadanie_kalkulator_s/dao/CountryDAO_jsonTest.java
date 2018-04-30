package com.kubiesh.zadanie_kalkulator_s.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.kubiesh.zadanie_kalkulator_s.entities.Country;

public class CountryDAO_jsonTest {
	
	CountryDAO_json component;

	@Before
	public void SetUp() {
		component=new CountryDAO_json("src/main/resources/data.json");
	}
	

	@Test
	public void testGetCountry() {
		Country expected = countrySetupPL();
		Country actual = component.getCountry("PL");
		assertEqualsCountry(expected,actual);
	}

	@Test
	public void testGetWorkDays() {
		int expectedWorkDays=22;
		assertEquals(expectedWorkDays,component.getWorkDays());
	}

	@Test
	public void testGetFinalCountryID() {
		String expectedFinalCountryID="PL";
		assertEquals(expectedFinalCountryID,component.getFinalCountryID());
	}
	
	private Country countrySetupPL() {
		Country country=new Country();
		country.setCountryID("PL");
		country.setCountryName("Poland");
		country.setCurrencyCode("PLN");
		country.setFixedCosts(new BigDecimal("1200"));
		country.setTaxRate(new BigDecimal("0.19"));
		return country;
	}
	
	private void assertEqualsCountry(Country expected, Country actual) {
		assertEquals(expected.getCountryID(), actual.getCountryID());
		assertEquals(expected.getCountryName(), actual.getCountryName());
		assertEquals(expected.getCurrencyCode(), actual.getCurrencyCode());
		assertEquals(expected.getFixedCosts(), actual.getFixedCosts());
		assertEquals(expected.getTaxRate(), actual.getTaxRate());
	}
}

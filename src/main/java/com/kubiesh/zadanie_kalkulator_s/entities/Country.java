package com.kubiesh.zadanie_kalkulator_s.entities;

import java.math.BigDecimal;

public class Country {
	private String countryName;
	private String currencyCode;
	private BigDecimal taxRate;
	private BigDecimal fixedCosts;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public BigDecimal getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
	public BigDecimal getFixedCosts() {
		return fixedCosts;
	}
	public void setFixedCosts(BigDecimal fixedCosts) {
		this.fixedCosts = fixedCosts;
	}
}

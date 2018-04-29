package com.kubiesh.zadanie_kalkulator_s.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.kubiesh.zadanie_kalkulator_s.currencyRateAPI.ICurrencyRate;
import com.kubiesh.zadanie_kalkulator_s.entities.Country;


@Service
public class FinalEarningsCalculator {
	@Autowired
	private ICurrencyRate currencyRateAPI;
	
	public static String finalCountryID;
	private Country country;
	private BigDecimal localEarnings;
	
	public FinalEarningsCalculator(Country country, BigDecimal localEarnings) {
		this.country=country;
		this.localEarnings=localEarnings;
	}
	
	public BigDecimal getFinalEarnings() {
		if (country.getCountryID().equals(finalCountryID)) {
			return localEarnings;
		}
		else {
			return calculateInForeignCurrency();
		}
	}
	
	private BigDecimal calculateInForeignCurrency() {
		BigDecimal currencyRate = currencyRateAPI.getCurrencyRate(country.getCurrencyCode());
		BigDecimal finalEarnings=localEarnings.multiply(currencyRate);
		return finalEarnings;
	}
}

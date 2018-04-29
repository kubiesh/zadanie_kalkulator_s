package com.kubiesh.zadanie_kalkulator_s.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kubiesh.zadanie_kalkulator_s.currencyRateAPI.ICurrencyRate;
import com.kubiesh.zadanie_kalkulator_s.entities.Country;


@Service
public class FinalEarningsCalculator {
	
	private ICurrencyRate currencyRateAPI;
	
	public static String finalCountryID;
	private static Country country;
	private static BigDecimal localEarnings;
	
	@Autowired
	public FinalEarningsCalculator(ICurrencyRate currencyRateAPI) {
		this.currencyRateAPI=currencyRateAPI;
	}
	
	public BigDecimal getFinalEarnings(Country country, BigDecimal localEarnings) {
		BigDecimal finalEarnings;
		FinalEarningsCalculator.country=country;
		FinalEarningsCalculator.localEarnings=localEarnings;
		if (country.getCountryID().equals(finalCountryID)) {
			finalEarnings=localEarnings;
		}
		else {
			finalEarnings= calculateInForeignCurrency();
		}
		return finalEarnings.setScale(2, RoundingMode.HALF_EVEN);
	}
	
	private BigDecimal calculateInForeignCurrency() {
		BigDecimal currencyRate = currencyRateAPI.getCurrencyRate(country.getCurrencyCode());
		BigDecimal finalEarnings=localEarnings.multiply(currencyRate);
		finalEarnings=finalEarnings.setScale(2, RoundingMode.HALF_EVEN);
		return finalEarnings;
	}
}

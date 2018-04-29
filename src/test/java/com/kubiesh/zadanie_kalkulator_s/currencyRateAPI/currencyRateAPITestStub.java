package com.kubiesh.zadanie_kalkulator_s.currencyRateAPI;

import java.math.BigDecimal;

public class currencyRateAPITestStub implements ICurrencyRate {

	@Override
	public BigDecimal getCurrencyRate(String currencyCode) {
		BigDecimal currencyRate;
		if (currencyCode.equals("GBP")) {
			currencyRate = new BigDecimal("4.8379");
		}
		else if (currencyCode.equals("EUR")) {
			currencyRate = new BigDecimal("4.2259");
		}
		else {
			currencyRate = new BigDecimal(0);
		}
		return currencyRate;
	}

}

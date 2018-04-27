package com.kubiesh.zadanie_kalkulator_s.currencyRateAPI;

import java.math.BigDecimal;

public interface ICurrencyRate {
	BigDecimal getCurrencyRate(String currencyCode);
}

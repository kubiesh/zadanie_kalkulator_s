package com.kubiesh.zadanie_kalkulator_s.currencyRateAPI.NBP;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.kubiesh.zadanie_kalkulator_s.currencyRateAPI.ICurrencyRate;

@PropertySource("classpath:NBPWebApi.properties")
public abstract class INBPWebApi implements ICurrencyRate {
	
	@Value("${url}") private String url;
	protected String format;
	protected String currencyCode;
	
	@Override
	public BigDecimal getCurrencyRate(String currencyCode) {
		return null;
	}
	
	public String getFullURL() {
		String fullURL=url+currencyCode+"format="+format;
		return fullURL;
	}

}

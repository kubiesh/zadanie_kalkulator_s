package com.kubiesh.zadanie_kalkulator_s.dao;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.kubiesh.zadanie_kalkulator_s.entities.Country;

@Component
@PropertySource("classpath:CountryDAO_json.properties")
public class CountryDAO_json implements ICountryDAO {
	
	@Value("${dataFilePath}") 
	private String dataFilePath;
	private int workDays;
	private Vector<Country> countries = new Vector<Country>();
	
	public CountryDAO_json() {
		
	};

	@Override
	public Country getCountry(String countryID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWorkDays() {
		return workdays;
	}

}

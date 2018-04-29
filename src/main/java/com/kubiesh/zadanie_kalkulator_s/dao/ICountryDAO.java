package com.kubiesh.zadanie_kalkulator_s.dao;

import com.kubiesh.zadanie_kalkulator_s.entities.Country;

public interface ICountryDAO {
	Country getCountry(String countryID);
	int getWorkDays();
	String getFinalCountryID();
}

package com.kubiesh.zadanie_kalkulator_s.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kubiesh.zadanie_kalkulator_s.entities.Country;
import com.kubiesh.zadanie_kalkulator_s.services.FinalEarningsCalculator;

@Component
@Primary
@PropertySource("classpath:CountryDAO_json.properties")
public class CountryDAO_json implements ICountryDAO {
	
	@Value("${dataFilePath}") 
	private String dataFilePath;
	private JsonNode rootNode;
	
	private int workDays;
	private String finalCountryID;
	private Vector<Country> countries = new Vector<Country>();
	
	public CountryDAO_json() {
		readTreeFromFile();
		loadWorkDays();
		loadFinalCountryID();
		loadCountries();
	};

	@Override
	public Country getCountry(String countryID) {
		Iterator<Country> it = countries.iterator();
		while (it.hasNext()) {
			Country country=it.next();
			if (countryID==country.getCountryID()) {
				return country;
			}
		}
		return null; //Never return null
	}

	@Override
	public int getWorkDays() {
		return workDays;
	}
	
	public String getFinalCountryID() {
		return finalCountryID;
	}
	
	private void readTreeFromFile() {
		byte[] jsonData=null;
		
		try {
			jsonData = Files.readAllBytes(Paths.get(dataFilePath));
		} catch (IOException e) {
			System.out.println("Blad odczytu z pliku pliku CountryDAO_json.properties");
			return;
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			rootNode = objectMapper.readTree(jsonData);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	private void loadWorkDays() {
		this.workDays=rootNode.path("workDays").asInt();
	}
	private void loadFinalCountryID() {
		this.finalCountryID=rootNode.path("finalCountryID").asText();
		// Inelegant dependency
		FinalEarningsCalculator.finalCountryID=finalCountryID;
	}
	
	private void loadCountries() {
		/* Worst possible implementation */
		JsonNode countriesNode = rootNode.path("countries");
		Iterator<JsonNode> it=countriesNode.elements();
		
		while(it.hasNext()){
			
			JsonNode element = it.next();
			Country country=new Country();
			country.setCountryID(element.path("countryID").asText());
			country.setCountryName(element.path("countryName").asText());
			country.setCurrencyCode(element.path("currencyCode").asText());;
			country.setTaxRate(new BigDecimal(element.path("taxRate").asText()));
			country.setFixedCosts(new BigDecimal(element.path("taxRate").asText()));
			
			countries.addElement(country);
		}
	}
	
}

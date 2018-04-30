package com.kubiesh.zadanie_kalkulator_s.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kubiesh.zadanie_kalkulator_s.dao.ICountryDAO;

@RestController
public class DataFileController {

	private ICountryDAO countryDAO;
	
	@Autowired
	public DataFileController(ICountryDAO countryDAO) {
		this.countryDAO=countryDAO;
	}
	
	@GetMapping("/data")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<byte[]> getDataFile() {
		byte[] dataFile = countryDAO.getDataFile();
		return new ResponseEntity<byte[]>(dataFile,HttpStatus.OK);
	}
}

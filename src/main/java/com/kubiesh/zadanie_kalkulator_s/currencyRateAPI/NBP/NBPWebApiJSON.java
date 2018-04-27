package com.kubiesh.zadanie_kalkulator_s.currencyRateAPI.NBP;

import java.io.IOException;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NBPWebApiJSON extends INBPWebApi {
	
	public NBPWebApiJSON() {
		this.format="json";
	}
	
	@Override
	public BigDecimal getCurrencyRate(String currencyCode) {
		//TO DO: Exception
		this.currencyCode=currencyCode;
		
		RestTemplate restRequest = new RestTemplate();
		ResponseEntity<String> response = restRequest.getForEntity(this.getFullURL(), String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jnode=null;
		try {
			jnode = mapper.readTree(response.getBody());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JsonNode mid = jnode.path("rates").path(0).path("mid");
		
	    BigDecimal currencyRate=new BigDecimal(mid.asText());
		
		return currencyRate;
	}
	
	
}

package com.kubiesh.zadanie_kalkulator_s.currencyRateAPI.NBP;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
@Primary
public class NBPWebApiJSON extends INBPWebApi {
	
	public NBPWebApiJSON() {
		this.format="json";
	}
	
	@Override
	public BigDecimal getCurrencyRate(String currencyCode) {
		//TO DO: Exception
		this.currencyCode=currencyCode;
		
		ResponseEntity<String> response = getResponseEntity();
		JsonNode jnode = getResponseBody(response);
		JsonNode mid = getCurrencyRate(jnode);
		
	    BigDecimal currencyRate=new BigDecimal(mid.asText());
		return currencyRate;
	}
	
	private ResponseEntity<String> getResponseEntity() {
		RestTemplate restRequest = new RestTemplate();
		ResponseEntity<String> response = restRequest.getForEntity(this.getFullURL(), String.class);
		return response;
	}
	private JsonNode getResponseBody(ResponseEntity<String> response) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jnode=null;
		try {
			jnode = mapper.readTree(response.getBody());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jnode;
	}
	private JsonNode getCurrencyRate(JsonNode jnode) {
		JsonNode mid = jnode.path("rates").path(0).path("mid");
		return mid;
	}
}

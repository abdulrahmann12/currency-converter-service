package com.integration.currency_converter.service;

import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.integration.currency_converter.dto.CurrencyConversionRequestDTO;
import com.integration.currency_converter.dto.CurrencyConversionResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CurrencyConverterService {

    private final RestTemplate restTemplate;

    private final String API_KEY = "0d64d96568a2e0f46bef078d"; 
    	
    public CurrencyConversionResponseDTO convertCurrency(CurrencyConversionRequestDTO requestDTO) {
    	
    	String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + requestDTO.getFrom();
    	
    	Map<String, Object> response = restTemplate.getForObject(url, Map.class);
    	
    	Map<String, Double> rates = (Map<String, Double>) response.get("conversion_rates");
    	
    	Double rate = rates.get(requestDTO.getTo());
    	
    	if(rate == null) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Failed to fetch supported currencies");
    	}
    	
    	double convertedAmount = rate * requestDTO.getAmount();
    	
        return new CurrencyConversionResponseDTO(
                requestDTO.getFrom(),
                requestDTO.getTo(),
                requestDTO.getAmount(),
                convertedAmount
        );
    }
    
    
    public Set<String> getSupportedCurrencies() {
        String url = "https://open.er-api.com/v6/latest/USD";
        Map response = restTemplate.getForObject(url, Map.class);

        Map<String, Object> rates = (Map<String, Object>) response.get("rates");
        return rates.keySet();
    }
}



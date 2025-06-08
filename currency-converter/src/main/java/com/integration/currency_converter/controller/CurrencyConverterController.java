package com.integration.currency_converter.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.currency_converter.dto.CurrencyConversionRequestDTO;
import com.integration.currency_converter.dto.CurrencyConversionResponseDTO;
import com.integration.currency_converter.service.CurrencyConverterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrencyConverterController {

	private final CurrencyConverterService currencyConverterService;
	
    @PostMapping("/convert")
    public ResponseEntity<CurrencyConversionResponseDTO> convertCurrency(@RequestBody CurrencyConversionRequestDTO requestDTO) {
        return ResponseEntity.ok(currencyConverterService.convertCurrency(requestDTO));
    }
    
    @GetMapping("/currencies")
    public ResponseEntity<Set<String>> getCurrencies() {
        return ResponseEntity.ok(currencyConverterService.getSupportedCurrencies());
    }
}

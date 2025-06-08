package com.integration.currency_converter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionResponseDTO {
    private String from;
    private String to;
    private double amount;
    private double convertedAmount;
    
}

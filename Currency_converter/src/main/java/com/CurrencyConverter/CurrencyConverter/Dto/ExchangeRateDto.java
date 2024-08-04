package com.CurrencyConverter.CurrencyConverter.Dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Data;

@Data
public class ExchangeRateDto {
    private Map<String, Double> rates = new HashMap<>();

    @JsonAnySetter
    public void setRate(String currency, Double rate) {
        this.rates.put(currency, rate);
    }
}

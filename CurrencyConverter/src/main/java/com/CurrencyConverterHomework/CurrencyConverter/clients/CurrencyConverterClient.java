package com.CurrencyConverterHomework.CurrencyConverter.clients;

import java.util.Map;


public interface CurrencyConverterClient {

    public Map<String, Double> getTheCurrencyConvertedRate(String fromCurrency, String toCurrency, double units);
}

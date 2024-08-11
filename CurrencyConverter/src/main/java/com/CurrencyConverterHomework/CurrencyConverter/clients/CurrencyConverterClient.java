package com.CurrencyConverterHomework.CurrencyConverter.clients;

public interface CurrencyConverterClient {

    public Double getTheCurrencyConvertedRate(String fromCurrency, String toCurrency, double units);
}

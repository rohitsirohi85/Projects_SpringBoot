package com.CurrencyConverterHomework.CurrencyConverter.clients.Impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.CurrencyConverterHomework.CurrencyConverter.clients.CurrencyConverterClient;
import com.CurrencyConverterHomework.CurrencyConverter.dto.CurrencyDto;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CurrencyConverterClientImpl implements CurrencyConverterClient {

    private final RestClient restClient;

     Logger logger = LoggerFactory.getLogger(CurrencyConverterClientImpl.class);

  @Override
public Map<String, Double> getTheCurrencyConvertedRate(String fromCurrency, String toCurrency, double units) {

    // Fetch the data from the external API using the RestClient
    CurrencyDto currencyDto = restClient.get()
        .uri(uriBuilder -> uriBuilder
            .path("v1/latest")
            .queryParam("currencies", toCurrency)
            .queryParam("base_currency", fromCurrency)
            .build())
        .header("apiKey", "fca_live_bVhUk8RK004QjSE0Ho96kikZtdWfBaPIV9eS7zYx")
        .retrieve()
        .onStatus(HttpStatusCode::is4xxClientError,(request, response) -> {
            logger.error("Error - {} {} {}",response.getBody(),request.getURI(),request.getHeaders());
            throw new HttpClientErrorException(response.getStatusCode(),response.getBody().toString());
        })
         .body(new ParameterizedTypeReference<>() {
         });  
       
    // Calculate the converted amount
    double convertedAmount = currencyDto.getData().get(toCurrency) * units;

    // Create a Map to store the result
    Map<String, Double> result = new HashMap<>();
    result.put(toCurrency, convertedAmount);

    return result;
}

    
}

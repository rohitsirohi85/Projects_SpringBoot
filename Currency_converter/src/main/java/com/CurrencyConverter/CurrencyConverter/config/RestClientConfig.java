package com.CurrencyConverter.CurrencyConverter.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
       @Value("${exchangeRatesService.base.url}")
    private String CURRENCY_EXCHANGE_URL;
    @Value("${exchangeRatesService.API_KEY}")
    private String API_KEY;

        @Bean
    @Qualifier("currencyRestClient")
    RestClient getCurrencyServiceRestClient(){
        return RestClient.builder()
                .baseUrl(CURRENCY_EXCHANGE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultStatusHandler(HttpStatusCode::is5xxServerError,(request, response) -> {
                    throw new RuntimeException("Server error occurred ");
                })
                .build();
    }
}

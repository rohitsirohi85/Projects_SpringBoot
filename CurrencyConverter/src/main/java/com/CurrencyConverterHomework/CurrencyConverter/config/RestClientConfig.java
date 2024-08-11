package com.CurrencyConverterHomework.CurrencyConverter.config;

import java.rmi.ServerException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    
      @Value("${currency.client.base.url}")
         private String BASE_URL;

      @Bean
      public RestClient restClient(){
        return RestClient.builder()
              .baseUrl(BASE_URL)
              .defaultHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE)
              .defaultStatusHandler(HttpStatusCode::is5xxServerError,(request,response)->{
                  throw new ServerException("Server Error Ocurred" + response.getBody());
              }).build();
              

      }

}

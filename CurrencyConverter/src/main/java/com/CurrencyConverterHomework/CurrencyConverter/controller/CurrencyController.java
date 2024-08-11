package com.CurrencyConverterHomework.CurrencyConverter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CurrencyConverterHomework.CurrencyConverter.clients.CurrencyConverterClient;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {
    
    private final CurrencyConverterClient converterClient;

    //http://localhost:8080/currency/convertCurrency?fromCurrency=INR&toCurrency=USD&units=500

      @GetMapping("/convertCurrency")
      public ResponseEntity<Double> getTheCurrencyConvertedRate(@RequestParam String fromCurrency , @RequestParam String toCurrency , @RequestParam double units){
        return ResponseEntity.ok(converterClient.getTheCurrencyConvertedRate(fromCurrency,toCurrency,units));
      }

}

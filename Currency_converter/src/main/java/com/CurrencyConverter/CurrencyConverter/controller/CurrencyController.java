package com.CurrencyConverter.CurrencyConverter.controller;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CurrencyConverter.CurrencyConverter.service.CurrencyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/convertCurrency")
@Data
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/{baseCurrency}/{currency}/{amount}")
    public Double getConvertedCurrency(@PathVariable String baseCurrency,@PathVariable String currency,@PathVariable Double amount){
        return currencyService.convertCurrency(baseCurrency,currency,amount);
    }
}


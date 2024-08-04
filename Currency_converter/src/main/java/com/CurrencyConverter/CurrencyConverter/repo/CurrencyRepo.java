package com.CurrencyConverter.CurrencyConverter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CurrencyConverter.CurrencyConverter.entities.Currency;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency,Long> {
     
}

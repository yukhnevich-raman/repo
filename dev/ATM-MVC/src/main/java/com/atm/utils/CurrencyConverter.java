package com.atm.utils;

import org.springframework.stereotype.Service;

import com.atm.web.Currency;

@Service
public class CurrencyConverter {
	
	public Double convert(String from , String to, double amount) {
		Currency currency = Currency.valueOf(from);		
		if (to.equalsIgnoreCase("USD")) {
			return amount*currency.getUsd();
		} else if (to.equalsIgnoreCase("BYR")) {
			return amount*currency.getByr();
		} else if (to.equalsIgnoreCase("EUR")) {
			return amount*currency.getEur();
		} else {
			return (double) 0;
		}
	}
}

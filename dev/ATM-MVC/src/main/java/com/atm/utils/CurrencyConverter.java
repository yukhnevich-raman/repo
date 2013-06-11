package com.atm.utils;

import com.atm.web.Currency;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverter {

    /**
     * Convert currencies
     * @param from currency
     * @param to currency
     * @param amount
     * @return double conversion result
     */
    public Double convert(String from, String to, double amount) {
        Currency currency = Currency.valueOf(from);
        if (to.equalsIgnoreCase("USD")) {
            return amount * currency.getUsd();
        } else if (to.equalsIgnoreCase("BYR")) {
            return amount * currency.getByr();
        } else if (to.equalsIgnoreCase("EUR")) {
            return amount * currency.getEur();
        } else {
            return (double) 0;
        }
    }
}

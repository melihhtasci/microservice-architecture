package com.stonemason.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyExchangeClient currencyExchangeClient;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion getConversionValue(@PathVariable("from") String from,
                                                 @PathVariable("to") String to,
                                                 @PathVariable("quantity") BigDecimal quantity) {

        CurrencyConversion currencyConversion = currencyExchangeClient.getExchangeValue(from, to);
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalAmount(quantity.multiply(currencyConversion.getConversionMultiple()));
        return currencyConversion;
    }

}

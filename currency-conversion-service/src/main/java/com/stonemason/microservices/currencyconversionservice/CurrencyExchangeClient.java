package com.stonemason.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeClient {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}

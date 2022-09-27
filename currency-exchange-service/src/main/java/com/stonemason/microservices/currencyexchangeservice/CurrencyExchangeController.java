package com.stonemason.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange-service/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {

        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
        return exchangeValue;
    }

}

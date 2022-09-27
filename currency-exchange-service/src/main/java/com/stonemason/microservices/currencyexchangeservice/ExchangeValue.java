package com.stonemason.microservices.currencyexchangeservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExchangeValue {
    @Id
    private Long id;

    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal conversionMultiple;
    private int port;
}

package com.stonemason.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator router(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(predicateSpec -> predicateSpec.path("/get")
                        .filters(f->f.addRequestHeader("MyHeader", "Special Header"))
                        .uri("http://httpbin.org:80"))
                .route(predicateSpec -> predicateSpec.path("/CURRENCY-CONVERSION-SERVICE/**")
                        .uri("lb://CURRENCY-CONVERSION-SERVICE"))
                .route(predicateSpec -> predicateSpec.path("/currency-conversion-service/**")
                        .uri("lb://CURRENCY-CONVERSION-SERVICE"))
                .route(predicateSpec -> predicateSpec.path("/CURRENCY-EXCHANGE-SERVICE/**")
                        .uri("lb://CURRENCY-EXCHANGE-SERVICE"))
                .route(predicateSpec -> predicateSpec.path("/currency-exchange-service/**")
                        .uri("lb://CURRENCY-EXCHANGE-SERVICE"))
                .build();
    }

}

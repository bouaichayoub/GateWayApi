package com.cap.gate.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayApiConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("commande-service", r -> r.path("/api/client/**")
                        .uri("lb://MS-COMMANDE"))
                .route("paiement-service", r -> r.path("/api/paiement/**")
                        .uri("lb://MS-PAIEMENT"))
                .build();
    }
}

package com.project.challenge.gatewayserver.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/ms-transfer-doc/v3/api-docs/swagger-config")
                		.filters(f -> f.rewritePath("/ms-transfer-doc/v3/api-docs/swagger-config", "/ms-transfer/ms-transfer-doc/v3/api-docs/swagger-config"))
                        .uri("http://localhost:8765/ms-transfer"))
                .route(r -> r.path("/ms-transfer-doc/v3/api-docs")
                		.filters(f -> f.rewritePath("/ms-transfer-doc/v3/api-docs", "/ms-transfer/ms-transfer-doc/v3/api-docs"))
                        .uri("http://localhost:8765/ms-transfer"))
                .build();
    }
}

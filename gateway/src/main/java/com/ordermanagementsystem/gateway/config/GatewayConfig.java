package com.ordermanagementsystem.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                // User Service Route
//                .route("user-service", r -> r
//                        .path("/api/users/**", "/api/login")
//                        .filters(f -> f
//                                .rewritePath("/api/users/verify/(?<segment>.*)", "/verify/${segment}")
//                                .rewritePath("/api/users/delete/(?<segment>.*)", "/users/delete/${segment}")
//                                .rewritePath("/api/users/(?<segment>.*)", "/users/${segment}")
//                        )
//                        .uri("lb://user-service")
//                )
//                // Order Service Routes
//                .route("order-service", r -> r
//                        .path("/api/orders/**")
//                        .filters(f -> f
//                                .rewritePath("/api/orders/(?<segment>.*)", "/orders/${segment}")
//                        )
//                        .uri("lb://order-service")
//                )
//                // Specific Order Service Route for Delete
//                .route("delete-order", r -> r
//                        .path("/api/orders/{id}")
//                        .and()
//                        .method("DELETE")
//                        .filters(f -> f
//                                .rewritePath("/api/orders/(?<id>.*)", "/orders/${id}")
//                        )
//                        .uri("lb://order-service")
//                )
//                // Specific Order Service Route for Get by ID
//                .route("get-order", r -> r
//                        .path("/api/orders/{id}")
//                        .and()
//                        .method("GET")
//                        .filters(f -> f
//                                .rewritePath("/api/orders/(?<id>.*)", "/orders/${id}")
//                        )
//                        .uri("lb://order-service")
//                )
//                // Specific Order Service Route for Get All Orders
//                .route("get-all-orders", r -> r
//                        .path("/api/orders/get-all-orders")
//                        .filters(f -> f
//                                .rewritePath("/api/orders/get-all-orders", "/orders/manager/all")
//                        )
//                        .uri("lb://order-service")
//                )
//                // Specific Order Service Route for Mark Complete
//                .route("complete-order", r -> r
//                        .path("/api/orders/complete/{id}")
//                        .and()
//                        .method("POST")
//                        .filters(f -> f
//                                .rewritePath("/api/orders/complete/(?<id>.*)", "/orders/complete/${id}")
//                        )
//                        .uri("lb://order-service")
//                )
//                .build();
//    }


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r
                        .path("/api/users/**", "/api/login")
                        .uri("lb://user-service")) // No RewritePath; direct forwarding
                .route("order-service", r -> r
                        .path("/api/orders/**")
                        .uri("lb://order-service")) // No RewritePath; direct forwarding
                .build();
    }




}


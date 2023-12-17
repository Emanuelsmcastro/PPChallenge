package com.project.challenge.mstransfer.mstransfer.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig{

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .httpBasic(HttpBasicConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
            		.anyRequest().authenticated())
            .csrf((csrf) -> csrf.disable());
        return http.build();
    }
}
package com.softwarePinas.SistemaControlVentas.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecuriyConfig {

    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeHttpRequests(auth-> auth.requestMatchers("log")
                        .permitAll()
                        .anyRequest().authenticated())
                .formLogin(form-> form.permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }


}

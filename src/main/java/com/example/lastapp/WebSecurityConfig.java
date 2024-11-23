package com.example.lastapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfig {

    // Bean pour encoder les mots de passe
    // @Bean
    // public PasswordEncoder bCryptPasswordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
       return NoOpPasswordEncoder.getInstance(); // Pas de chiffrement
    }

    // Bean pour la configuration du filtre de sécurité
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET,"/voucherapi/vouchers/**","/","/showGetVoucher")
        .hasAnyRole("USER","ADMIN")
        .requestMatchers(HttpMethod.GET,"/showCreateVoucher","/createVoucher","/create")
        .hasRole("ADMIN")
        .requestMatchers(HttpMethod.POST,"/voucherapi/vouchers","/saveVoucher")
        .hasRole("ADMIN")
        .requestMatchers(HttpMethod.POST,"/getVoucher")
        .hasAnyRole("USER","ADMIN").and()
        .csrf().disable();


        return http.build();
    }
}

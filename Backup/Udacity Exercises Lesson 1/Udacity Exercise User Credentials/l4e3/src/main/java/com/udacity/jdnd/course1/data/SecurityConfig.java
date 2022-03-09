package com.udacity.jdnd.course1.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/orders", "/css/**", "/js/**").permitAll()
                .anyRequest().authenticated();
        //authorizes any authenticated requests to /orders, /css/**, /js/**
        http.formLogin()
                .loginPage("/login")
                .permitAll();
        http.formLogin()
                .defaultSuccessUrl("/tacos", true);


    }
}

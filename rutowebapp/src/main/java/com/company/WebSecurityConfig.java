package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login").permitAll() // Login səhifəsi hamıya açıqdır
                        .requestMatchers("/mainpage").permitAll()
                        .requestMatchers("/users").permitAll()// Bu URL-lər hamıya açıqdır
                        .anyRequest().authenticated() // Digər bütün URL-lərə giriş üçün autentifikasiya tələb olunur
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/mainpage", false) // Uğurlu login olduqda /users səhifəsinə yönəldir
                        .failureUrl("/login?error=true") // Giriş uğursuz olduqda yönləndirmə
                        .permitAll() // Login formu hamıya açıqdır
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Logout URL
                        .logoutSuccessUrl("/login?logout=true") // Uğurlu logoutdan sonra yönləndirmə
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable()); // CSRF-i ehtiyac yoxdursa deaktiv etmək


        return http.build();
    }
}

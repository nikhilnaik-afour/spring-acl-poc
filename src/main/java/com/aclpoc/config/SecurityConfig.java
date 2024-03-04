package com.aclpoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(Customizer.withDefaults())
//            .authorizeHttpRequests(authorize -> authorize
//                .anyRequest().authenticated()
//            )
//            .httpBasic(Customizer.withDefaults())
//            .formLogin(Customizer.withDefaults());
//        return http.build();
//    }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(t -> t.disable()).authorizeHttpRequests(authorize -> 
		authorize.requestMatchers("/**").permitAll()
		.requestMatchers("/api/v1/client/**").permitAll());
//          .httpBasic(Customizer.withDefaults())
//          .formLogin(Customizer.withDefaults());
		return http.build();
	}

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .csrf().disable()
//                .authorizeHttpRequests().requestMatchers("/users/register").permitAll().and()
//                .build();
//    }
}
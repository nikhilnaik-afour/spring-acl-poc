package com.aclpoc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.aclpoc.jwt.JwtAuthFilter;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthFilter jwtFilter;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(t -> t.disable()) // disabled only for testing, disabling CSRF is risky, need to check a proper
									// way to implement this
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/v1/client/generateToken")
						.permitAll().requestMatchers("/api/v1/client").authenticated())
				.addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//		.permitAll().requestMatchers("/api/v1/client").authenticated()).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//		.requestMatchers("/swagger-ui/index*").permitAll());
//		return http.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).build();
		return http.build();
	}

//	
//	@Bean
//    public AuthenticationProvider authenticationProvider(@Autowired UserDetailsService userDetailsService, @Autowired PasswordEncoder passEncodeer) { 
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(); 
//        authenticationProvider.setUserDetailsService(userDetailsService); 
//        authenticationProvider.setPasswordEncoder(passEncodeer); 
//        return authenticationProvider; 
//    } 
//  
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
package com.aclpoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passEncoder) {
        var uds = new InMemoryUserDetailsManager();
//        var u1 = User.withUsername("nik").password(passEncoder.encode("1234")).roles("ADMIN").authorities("read", "write", "delete").build();
//        var u1 = User.withUsername("nik").password("1234").roles("ADMIN").build();
//        var u2 = User.withUsername("TestClient").password("A1234").roles("USER").build();
        var u1 = User.withUsername("nik").password(passEncoder.encode("1234")).roles("ADMIN").build();
        var u2 = User.withUsername("TestClient").password(passEncoder.encode("A1234")).roles("USER").build();

        uds.createUser(u1);
        uds.createUser(u2);

        return uds;
    }

}

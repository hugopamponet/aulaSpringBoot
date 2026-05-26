package br.com.pratica.login.infra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfiguracaoSeguranca {
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Execpetion{
        http
           .csrf(csrf -> csrf.disable())
           .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll());
        
        return http.build();
    }
}

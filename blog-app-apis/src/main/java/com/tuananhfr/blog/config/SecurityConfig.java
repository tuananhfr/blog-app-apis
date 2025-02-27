package com.tuananhfr.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tuananhfr.blog.security.JwtAuthenticationEntryPoint;
import com.tuananhfr.blog.security.JwtAuthenticationFilter;


@Configuration
@EnableMethodSecurity
@EnableWebMvc
public class SecurityConfig {

	public static final String[] PUBLIC_URLS = {"/api/v1/auth/**", "/v3/api-docs", "/swagger-ui/**", "/swagger-ui.html"}; 

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
//	@Autowired
//	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
//    @Autowired
//    private CustomUserDetailService customUserDetailService;


    
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
	    return new JwtAuthenticationFilter();
	}
    

    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Désactivation de CSRF pour le développement
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers(PUBLIC_URLS).permitAll()
            		.requestMatchers(HttpMethod.GET).permitAll()
                .anyRequest().authenticated()
            )
            .exceptionHandling(ex -> ex.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)) // Gestion des exceptions
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session
            .httpBasic(Customizer.withDefaults());
        
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
    
    
    
}

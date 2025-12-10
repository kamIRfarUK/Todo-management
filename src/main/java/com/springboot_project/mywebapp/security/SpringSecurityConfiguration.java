package com.springboot_project.mywebapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		
		
		UserDetails userDetails1=User.builder()
				.passwordEncoder(passwordEncoder )
				.username("admin")
				.password("password")
				.roles("USER","ADMIN")
				.build();
		
		UserDetails userDetails2=User.builder()
				.passwordEncoder(passwordEncoder )
				.username("parker")
				.password("password")
				.roles("USER","ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(userDetails1,userDetails2);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		
		http.formLogin(Customizer.withDefaults());
		
		http
        .csrf(csrf -> csrf.disable()) // Disables CSRF protection
        .headers(headers -> headers
            .frameOptions(frameOptions -> frameOptions.disable()) // disable X-Frame-Options entirely
        );
		
		return http.build();
		
	}
}

package com.smartjobportalsystem.smartjobportalsystemapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;

	public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())

				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.httpBasic(basic -> basic.disable()).formLogin(form -> form.disable())

				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/auth/**", "/user/api/insertUser", "/swagger-ui/**", "/swagger-ui.html",
								"/v3/api-docs/**", "/swagger-resources/**", "/webjars/**", "/actuator/health")
						.permitAll()

						.requestMatchers("/Jobs/api/**").hasAnyRole("ADMIN", "RECRUITER")

						.requestMatchers("/application/api/**").hasAnyRole("ADMIN", "JOB_SEEKER", "RECRUITER")

						.requestMatchers("/resume/api/**").hasAnyRole("ADMIN", "JOB_SEEKER")

						.requestMatchers("/notification/api/**").authenticated()

						.requestMatchers("/user/api/**").hasRole("ADMIN")

						.anyRequest().authenticated())

				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
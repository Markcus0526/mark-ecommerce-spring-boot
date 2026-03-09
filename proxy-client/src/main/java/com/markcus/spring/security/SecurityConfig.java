package com.markcus.spring.security;

import com.markcus.spring.business.user.model.RoleBasedAuthority;
import com.markcus.spring.config.filter.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig { // 1. REMOVED 'extends WebSecurityConfigurerAdapter'

	private final JwtRequestFilter jwtRequestFilter;

	// Note: PasswordEncoder and UserDetailsService are now auto-wired by
	// Spring Security's AuthenticationManager without explicit configuration here.

	public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
		this.jwtRequestFilter = jwtRequestFilter;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.cors(AbstractHttpConfigurer::disable) // 2. NEW Lambda DSL syntax
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth -> auth // 3. Changed from 'authorizeRequests'
						.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // 4. Changed from 'antMatchers'
						.requestMatchers("/", "/index", "**/css/**", "**/js/**").permitAll()
						.requestMatchers("/api/authenticate/**").permitAll()
						.requestMatchers("/api/categories/**").permitAll()
						.requestMatchers("/api/products/**").permitAll()
						.requestMatchers("/api/**")
						.hasAnyAuthority(RoleBasedAuthority.ROLE_ADMIN.name(),
								RoleBasedAuthority.ROLE_USER.name())
						.requestMatchers("/actuator/health/**", "/actuator/info/**")
						.permitAll()
						.requestMatchers("/actuator/**")
						.hasAnyAuthority(RoleBasedAuthority.ROLE_ADMIN.name())
						.anyRequest().authenticated()
				)
				.headers(headers -> headers
						.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
				)
				.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				)
				.addFilterBefore(this.jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	// 5. NEW way to expose AuthenticationManager
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
}























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
				.cors(AbstractHttpConfigurer::disable)
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
						.requestMatchers("/", "/index", "/css/**", "/js/**").permitAll()

						// 1. Move ALL permitAll rules to the TOP
						// 2. Explicitly include the /app/ prefix for your authentication endpoint
						.requestMatchers("/app/api/authenticate/**", "/api/authenticate/**").permitAll()

						// 3. Keep specific resource permits above the catch-all
						.requestMatchers("/api/authenticate/**").permitAll()
						.requestMatchers("/api/categories/**").permitAll()
						.requestMatchers("/api/products/**").permitAll()
						.requestMatchers("/api/payments/**").permitAll()
						.requestMatchers("/api/shippings/**").permitAll()
						.requestMatchers("/api/carts/**").permitAll()
						.requestMatchers("/api/orders/**").permitAll()
						.requestMatchers("/api/favourites/**").permitAll()
						.requestMatchers("/api/credentials/**").permitAll()
						.requestMatchers("/api/addresses/**").permitAll()
						.requestMatchers("/api/verificationTokens/**").permitAll()

						// 4. This restricted block MUST come after the permits above
						.requestMatchers("/api/**", "/app/api/**")
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























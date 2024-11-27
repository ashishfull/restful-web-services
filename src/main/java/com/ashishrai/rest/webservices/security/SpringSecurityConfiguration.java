
package com.ashishrai.rest.webservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		/*// authorize all requests
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		// if a request is not authenticated, return default popup
		http.httpBasic(withDefaults());
		// disable CSRF to allow POST and PUT
		http.csrf(csrf -> csrf.disable());*/
		// all of the above can be written in one line also, as it uses builder pattern
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.anyRequest().authenticated()).httpBasic(withDefaults());
		return http.build();
	}
}

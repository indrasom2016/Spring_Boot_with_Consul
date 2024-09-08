package com.indrasom.ServiceA.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigs {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
	    UserDetails john = User.builder().username("john").password("{noop}john123").roles("EMPLOYEE").build();
	    UserDetails jarvo = User.builder().username("jarvo").password("{noop}jarvo123").roles("EMPLOYEE", "MANAGER").build();
	    UserDetails indra = User.builder().username("indra").password("{noop}indra123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();
	    return new InMemoryUserDetailsManager(john, jarvo, indra);
	}

	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
        										.requestMatchers("/actuator/**").permitAll()
                                                .requestMatchers(HttpMethod.GET, "/api/service1/employees").hasRole("EMPLOYEE")
                                                .requestMatchers(HttpMethod.GET, "/api/service1/employees/*").hasRole("EMPLOYEE")
                                                .requestMatchers(HttpMethod.POST, "/api/service1/employees").hasRole("MANAGER")
                                                .anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults()); // Ensure HTTP Basic Authentication is configured
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}

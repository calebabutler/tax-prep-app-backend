package com.skillstorm.taxprepapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeHttpRequests) ->
            authorizeHttpRequests
                .requestMatchers("/logout_success").permitAll()
                .anyRequest().authenticated()
                )
                .logout(logout -> logout.deleteCookies("JSESSIONID").invalidateHttpSession(true)
                        .logoutUrl("/logout").logoutSuccessUrl("/logout_success"));
        
        http.csrf(csrf -> csrf.disable());

        http.cors(cors -> {
            cors.configurationSource(request -> {
                CorsConfiguration corsConfig = new CorsConfiguration();

                corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:5173")); 
                corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));  
                corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));   
                corsConfig.setAllowCredentials(true);                               
                corsConfig.setMaxAge(3600L); 

                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                source.registerCorsConfiguration("/**", corsConfig);
                return corsConfig;
            });
        });
        http.oauth2Login(withDefaults());

        return http.build();
    }

}

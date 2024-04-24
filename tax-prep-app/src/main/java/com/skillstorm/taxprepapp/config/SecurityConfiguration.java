package com.skillstorm.taxprepapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) ->
            request.requestMatchers("users/register").permitAll()
                    .requestMatchers("users/goodbye").permitAll()
                    .requestMatchers("users/hello").authenticated()
        ).formLogin(formLogin ->
                formLogin.loginProcessingUrl("/login")
                        .defaultSuccessUrl("/users/hello", true)
                        .failureHandler(new SimpleUrlAuthenticationFailureHandler("/users/goodbye"))
        );

        http.csrf((csrf) -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}

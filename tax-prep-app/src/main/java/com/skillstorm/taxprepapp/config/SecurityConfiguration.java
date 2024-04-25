package com.skillstorm.taxprepapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((request) ->
            request.anyRequest().authenticated()
                    // .requestMatchers("users/register").permitAll()
                    // .requestMatchers("users/goodbye").permitAll()
                    // .requestMatchers("users/hello").authenticated()
        // ).formLogin(formLogin ->
        //         formLogin.loginProcessingUrl("/login")
        //                 .defaultSuccessUrl("/users/hello", true)
        //                 .failureHandler(new SimpleUrlAuthenticationFailureHandler("/users/goodbye"))
        );

        http.csrf((csrf) -> csrf.disable());
        http.oauth2Login(withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}

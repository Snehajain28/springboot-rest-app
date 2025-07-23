//package com.oracle.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf(csrf -> csrf.disable()) // Disable CSRF for REST APIs
//            .authorizeHttpRequests(auth -> auth
//            		 .requestMatchers(HttpMethod.GET, "/customer-api").hasRole("USER")
//                     .requestMatchers(HttpMethod.GET, "/customer-api/**").hasRole("USER")
//                     .requestMatchers(HttpMethod.POST, "/customer-api").hasRole("USER")
//                     .requestMatchers(HttpMethod.PUT, "/customer-api").hasRole("USER")
//                     .requestMatchers(HttpMethod.DELETE, "/customer-api/**").hasRole("USER")
//            )
//            .httpBasic(Customizer.withDefaults()); // or use .formLogin() for web apps
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder()
//            .username("user")
//            .password(passwordEncoder().encode("password"))
//            .roles("USER")
//            .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    @Bean
//    public UserDetailsService adminDetailsService() {
//        UserDetails user = User.builder()
//            .username("admin")
//            .password(passwordEncoder().encode("password1"))
//            .roles("ADMIN")
//            .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
//   
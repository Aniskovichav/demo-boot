package com.example.demoboot.config;

import com.example.demoboot.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeHttpRequests().requestMatchers("/register").permitAll().requestMatchers("home")
//                .permitAll().and().formLogin().loginPage("/login").loginProcessingUrl("/login")
//                .defaultSuccessUrl("/home", true).permitAll().and().logout().invalidateHttpSession(true)
//                .clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout").permitAll();
//
//        return http.build();
//
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth ->
                auth.requestMatchers("/register").permitAll().requestMatchers("home")
                        .permitAll());

        // LOGIN
        http.formLogin(formLogin ->
                formLogin
                        .loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/home", true)
                        .permitAll());
        // LOGOUT
        http.logout(logout ->
                logout.invalidateHttpSession(true).clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll());
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());

        //JSR 330 250 107 380
        //CGlib, JDK Dinamic Proxy -> Bit Buddy
        // Micro profile
        //паттернты GOF, SOLID, GRASPS, DRY, KISS
        //SOA vs microservices
        // DDD
        //Camunda, BPM flow
        //SWF
        //Docker
        //leeckvy base, GWT token
        //Vaadin, PWA
        //firebase, vrsl (versel)
        //maven plugin gen java protegeproject/maven-code-gen-plugin
        //https://github.com/protegeproject/maven-code-gen-plugin

//        st@A503PC3 MINGW64 ~
//                $ sdk install java 23-oracle
//
//        Downloading: java 23-oracle
//
//        In progress...
//
//######################################################################## 100,0%
//
//                Installing: java 23-oracle
//        Done installing!
//
//
//                Setting java 23-oracle as default.
//
//        st@A503PC3 MINGW64 ~
//                $ sdk install java 23-open
//
//        Downloading: java 23-open
//
//        In progress...
//
//######################################################################## 100,0%
//
//                Installing: java 23-open
//        Done installing!
//
//
//                Setting java 23-open as default.
//
//        st@A503PC3 MINGW64 ~
//                $ sdk list groove
//
//        Stop! groove is not a valid candidate.
//
//                st@A503PC3 MINGW64 ~
//                $ sdk list java
//
//        st@A503PC3 MINGW64 ~
//                $ sdk list groovy
//
//        st@A503PC3 MINGW64 ~
//                $ sdk install groovy 5.0.0
//
//        Stop! groovy 5.0.0 is not available. Possible causes:
// * 5.0.0 is an invalid version
// * groovy binaries are incompatible with your platform
//                * groovy has not been released yet
//
//        Tip: see all available versions for your platform:
//
//        $ sdk list groovy
//
//        st@A503PC3 MINGW64 ~
//                $ sdk list groovy
//
//        st@A503PC3 MINGW64 ~
//                $ sdk install groovy 4.0.23
//
//        Downloading: groovy 4.0.23
//
//        In progress...
//
//######################################################################## 100,0%
//
//                Installing: groovy 4.0.23
//        Done installing!
//
//
//                Setting groovy 4.0.23 as default.
//        $ sdk list gradle
//
//        st@A503PC3 MINGW64 ~
//                $ $ sdk list gradle
//        bash: $: command not found
//
//        st@A503PC3 MINGW64 ~
//                $ sdk list gradle
//
//        st@A503PC3 MINGW64 ~
//                $ sdk install gradle 8.10
//
//        Downloading: gradle 8.10
//
//        In progress...
//
//######################################################################## 100,0%-#O#- #   #                                            ######################################################################## 100,0%
//
//                Installing: gradle 8.10
//        Done installing!
//
//
//                Setting gradle 8.10 as default.
//
//        st@A503PC3 MINGW64 ~
//                $

    }
}

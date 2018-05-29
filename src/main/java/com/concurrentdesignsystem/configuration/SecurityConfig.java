//package com.concurrentdesignsystem.configuration;
//
//import com.concurrentdesignsystem.authentication.filter.LoginFilter;
//import com.concurrentdesignsystem.authentication.filter.TokenAuthFilter;
//import com.concurrentdesignsystem.authentication.service.TokenAuthService;
//import com.concurrentdesignsystem.authentication.service.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Value("${token.secret}")
//    public String secret;
//
//    private final CustomUserDetailsService customUserDetailsService;
//
//    private final TokenAuthService tokenAuthService;
//
//    public SecurityConfig(CustomUserDetailsService customUserDetailsService, TokenAuthService tokenAuthService) {
//        super(true);
//        this.customUserDetailsService = customUserDetailsService;
//        this.tokenAuthService = tokenAuthService;
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .exceptionHandling().and()
//                .anonymous().and()
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/favicon.ico").permitAll()
//                .antMatchers("/resources/**").permitAll()
//                .anyRequest().authenticated().and()
//                .addFilterBefore(new TokenAuthFilter(tokenAuthService), UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new LoginFilter("/auth/login", authenticationManager(), tokenAuthService), UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return customUserDetailsService;
//    }
//}

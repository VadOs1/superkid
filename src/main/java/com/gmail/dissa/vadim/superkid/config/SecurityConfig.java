package com.gmail.dissa.vadim.superkid.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Setting security rules
    // TODO: DATABASE USER STORE
    // TODO: METHOD SECURITY LEVEL
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout()
                .invalidateHttpSession(false)
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin/")
                .and()
                .csrf().disable();
    }

    // Adding in-memory users
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("vadim").password("111111").roles("ADMIN").and()
                .withUser("natalia").password("222222").roles("ADMIN");
    }
}
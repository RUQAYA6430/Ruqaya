package com.ruqaya.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class StudentSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/save/examResult").hasAnyRole("LEC")
                .antMatchers(HttpMethod.PUT, "/update/examResult").hasAnyRole("LEC")
                .antMatchers(HttpMethod.GET, "/get/examResult").hasAnyRole("STUDENT")
                .antMatchers(HttpMethod.GET, "/get/all").hasAnyRole("STUDENT")
                .antMatchers(HttpMethod.GET, "/get/all").hasAnyRole("LEC")
                .antMatchers(HttpMethod.DELETE, "/remove/examResult").hasAnyRole("ADMIN").and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user123").password("{noop}password").roles("USER").and()
                .withUser("admin123").password("{noop}password").roles("ADMIN").and().withUser("test123")
                .password("{noop}password").roles("USER").and().withUser("ruqaya").password("{noop}password")
                .roles("ADMIN").and().withUser("lec1").password("{noop}password")
                .roles("LEC");
    }
}

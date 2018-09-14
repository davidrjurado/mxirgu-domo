package com.mxirgu.domo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mxirgu.domo.service.MyAppUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
@ComponentScan(basePackages = { "com.mxirgu.domo" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyAppUserDetailsService myAppUserDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/**").hasAnyRole("ADMIN","USER")
		.and().formLogin()  //login configuration
                .loginPage("/login.jsp")
                .loginProcessingUrl("/authenticate")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")	
		.and().logout()    //logout configuration
		.logoutUrl("/appLogout") 
		.logoutSuccessUrl("/login.jsp")
		.and().exceptionHandling() //exception handling configuration
		.accessDeniedPage("/error");
	} 	
        @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(myAppUserDetailsService).passwordEncoder(passwordEncoder());
	}
        @Bean
        public PasswordEncoder passwordEncoder() {
    	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	        return passwordEncoder;
        }
}   
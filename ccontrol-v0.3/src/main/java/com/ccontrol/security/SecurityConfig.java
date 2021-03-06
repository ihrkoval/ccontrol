package com.ccontrol.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

    @Configuration
	@EnableWebSecurity
	@EnableGlobalMethodSecurity(securedEnabled = true)
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Autowired
	    private UserDetailsServiceIMPL userDetailsService;
		
		@Autowired
	    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService)/*.passwordEncoder(getShaPasswordEncoder())*/;
	    }
		
		  /*@Bean
		    public ShaPasswordEncoder getShaPasswordEncoder(){
		        return new ShaPasswordEncoder();
		    }*/
		
		@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	                .authorizeRequests()
	                .antMatchers("/resources/**", "/**").permitAll()
	                .antMatchers("/crossdomain.xml").permitAll()
	                .antMatchers("/cp/**, ").authenticated()
	                //.antMatchers("/api/**").permitAll()
	                //.antMatchers("/").access("ADMIN")
	                .anyRequest().permitAll()
	                .and();

	        http.formLogin()
	                .loginPage("/home")
	                .loginProcessingUrl("/j_spring_security_check")
	                .failureUrl("/error").defaultSuccessUrl("/cp")
	                .usernameParameter("j_username")
	                .passwordParameter("j_password")
	                .permitAll();

	        http.logout()
	                .permitAll()
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/")
	                .invalidateHttpSession(true);
	    }

	}




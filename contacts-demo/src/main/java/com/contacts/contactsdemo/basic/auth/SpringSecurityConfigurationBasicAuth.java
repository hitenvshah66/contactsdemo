package com.contacts.contactsdemo.basic.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

	
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
      http
        .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out
          .and()
        .authorizeRequests()
          .antMatchers("/", "add", "delete/{id}", "save", "contacts")
            .permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/contacts")
            .permitAll()
            .and()
        .logout()
            .permitAll()
            .and()
        .httpBasic()
            .and()
        .csrf().disable(); //Disable CSRF
      http.headers().frameOptions().disable();
    }
	
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {  
    	auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
    	auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
    }

}

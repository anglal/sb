package com.secureapp.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

//As long as @Configuration or @EnableWebSecurity is used no overriding or autowiring needed
// Method arguments must be same and names can be anything

@EnableWebSecurity
@Configuration
class Sb1SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/login*").permitAll()
			//.antMatchers("/index","/").permitAll()
			.antMatchers("/users").hasAnyRole("employee","client")
			.antMatchers("/users/**").hasAuthority("admin")
			.antMatchers("/**").hasAnyRole("employee", "client")
			.anyRequest().authenticated()
			.and()
			.httpBasic()
			.and()
			.formLogin()
			.loginPage("/login").usernameParameter("username").passwordParameter("password")
			.loginProcessingUrl("/doLogin")
			.defaultSuccessUrl("/index",true)
			.failureUrl("/loginFailed").permitAll();
//			.and()
//			.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
	//@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("Lal").password("{noop}Lal@123").roles("employee")
			.and()
			.withUser("Admin").password("{noop}Admin@123").authorities("admin")
			.and()
			.withUser("All").password("{noop}All@123").roles("client");
	
//		.and()
//		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
}
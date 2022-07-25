package com.corporacionaoe.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.corporacionaoe.app.auth.handler.LoginSuccessHandler;
import com.corporacionaoe.app.models.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JpaUserDetailsService userDetailService;
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{

		builder.userDetailsService(userDetailService)
		.passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/img/**", "/listar", "/locale", "/api/clientes/**").permitAll()
		.anyRequest().authenticated()
		.and()
			.formLogin()
			.successHandler(successHandler)
			.loginPage("/login")
			.permitAll()
		.and()
			.logout()
			.permitAll()
		.and()
			.exceptionHandling()
			.accessDeniedPage("/error_403");
	}
	
	
	
}

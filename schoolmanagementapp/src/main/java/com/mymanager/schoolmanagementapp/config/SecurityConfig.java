package com.mymanager.schoolmanagementapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	
	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/").hasAnyRole("PROFESSOR", "SUPERVISOR")
			.antMatchers("/professors/list").hasAnyRole("SUPERVISOR","PROFESSOR")
			.antMatchers("/professors/showCourses*").hasAnyRole("SUPERVISOR","PROFESSOR")
			.antMatchers("/professors/*").hasRole("SUPERVISOR")
			.antMatchers("/students/list").hasAnyRole("SUPERVISOR","PROFESSOR")
			.antMatchers("/students/*").hasRole("SUPERVISOR")
			.antMatchers("/courses/list").hasAnyRole("SUPERVISOR","PROFESSOR")
			.antMatchers("/courses/*").hasRole("SUPERVISOR")
			.antMatchers("/classLevels/list").hasAnyRole("SUPERVISOR","PROFESSOR")
			.antMatchers("/classLevels/*").hasRole("SUPERVISOR")
			.antMatchers("/coursesProfessors/*").hasRole("SUPERVISOR")
			.antMatchers("/coursesStudents/*").hasRole("SUPERVISOR")
			.antMatchers("/admins/*").hasRole("SUPERVISOR")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
	
	

	
}

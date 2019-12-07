package com.dish.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Esta clase define la seguridad de nuetra api REST
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */

@EnableWebSecurity
@Configuration
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
	
	/**
	*
	* Usuarios por defecto
	* @param define la manera de autenticarse, definiendo ciertos usarios y roles
	*/
	@Autowired
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("user")
            .password("{noop}pass")
            .roles("USER")
            .and()
          .withUser("admin")
            .password("{noop}admin")
            .roles("USER", "ADMIN");
    }
 
	
	/**
	*
	* Método que sirve para administrar la seguridad de nuestra API REST,
	* en este caso todo lo que se encuentre en http://localhost:8080/proyectos no tendrá seguridad,
	* mientras que http://localhost:8080/auth/proyectos necesitará autenticación forzosa
	*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .cors().and().csrf().disable()
          .authorizeRequests()
          .antMatchers("/login").permitAll()
          .antMatchers("/proyectos").permitAll()
          .antMatchers("/proyectos/**").permitAll()
          .antMatchers("/auth/proyectos").authenticated()
          .and()
          .httpBasic();
    }
    
    

}

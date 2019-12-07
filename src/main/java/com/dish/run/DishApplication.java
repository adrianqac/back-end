package com.dish.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Esta clase es la principal, el punto de partida de nuestro proyecto
 * @author: Adrian Vazquez
 * @version: 1.0.0
 */

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.dish"})
@EntityScan("com.dish.model")
@EnableJpaRepositories("com.dish.repository")
public class DishApplication {

	public static void main(String[] args) {
		SpringApplication.run(DishApplication.class, args);
	}

}

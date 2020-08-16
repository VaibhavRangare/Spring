package com.vaibhav.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.vaibhav.beans")
@PropertySource("classpath:services.properties")
public class BeanConfig {

	@Bean
	public ExternalService firstExternalServiceImp() {
		// Bean id = firstExternalServiceImp
		return new FirstExternalServiceImp();
	}

	@Bean
	public ExternalService secondExternalServiceImp() {
		// Bean id = secondExternalServiceImp
		return new SecondExternalServiceImp();
	}

	@Bean
	public EntityInt entityOne() {
		// Bean id = entityOne
		EntityOne mySwimCoach = new EntityOne(secondExternalServiceImp());
		return mySwimCoach;
	}

}

package com.learn.setup;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

	public MyApplicationContextInitializer() {
		super();
	}
	
	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		 final ConfigurableEnvironment environment = applicationContext.getEnvironment();
	        final String activeProfiles = environment.getProperty("spring.profiles.active");

	        System.out.println("The active profiles are"+ activeProfiles);

	        if (activeProfiles != null) {
	            environment.setActiveProfiles(activeProfiles.split(","));
	        }
	}
	
	

}

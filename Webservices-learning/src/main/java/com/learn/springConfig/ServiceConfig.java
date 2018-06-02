package com.learn.springConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.learn.service")
public class ServiceConfig {

	public ServiceConfig() {
		super();
	}

	// beans

}

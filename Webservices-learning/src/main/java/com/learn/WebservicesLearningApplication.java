package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.learn.springConfig.ContextConfig;
import com.learn.springConfig.PersistenceJpaConfig;
import com.learn.springConfig.SecurityConfig;
import com.learn.springConfig.ServiceConfig;
import com.learn.springConfig.WebConfig;

@SpringBootApplication
@Import({
	ContextConfig.class,
	PersistenceJpaConfig.class,
	ServiceConfig.class,
	WebConfig.class,
	SecurityConfig.class
})
public class WebservicesLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebservicesLearningApplication.class, args);
	}
}

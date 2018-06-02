package com.learn.client;


import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.CoreMatchers.not;

import java.util.List;

import org.hamcrest.Matchers;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.learn.persistence.model.Role;
import com.learn.springConfig.ContextConfig;
import com.learn.springConfig.PersistenceJpaConfig;

@ContextConfiguration(classes = {ContextConfig.class,  PersistenceJpaConfig.class }, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BasicLiveTest {
	
	private static final String USER = "admin@fake.com";
	private static final String PASSWORD = "adminpass";

	@Test
	public void whenAllRolesAreRetrived_then200ok() {
		final String uri = "http://localhost:8080/api/roles";
		Response response = RestAssured.given().auth().preemptive().basic(USER, PASSWORD).accept(ContentType.JSON).get(uri);
		assertThat(response.getStatusCode(), Matchers.equalTo(200));
	}
	
	@Test
	public void whenAllRolesRetreived_AtLeastOneExists() {
		final String uri = "http://localhost:8080/api/roles";
		Response response  = RestAssured.given().auth().preemptive().basic(USER, PASSWORD).accept(ContentType.JSON).get(uri);
		List<Role> roles = response.as(List.class);
		
		assertThat(roles, not(Matchers.<Role> empty()));
	}
	
	@Test
	public void whenCreatingNewRole_RoleCanBeRetrieved() {
		final String uri = "http://localhost:8080/api/roles";
		final Role role = new Role(3L, "EDITOR");
		Response response = RestAssured.given().auth().preemptive().basic(USER, PASSWORD).accept(ContentType.JSON)
									.contentType(ContentType.JSON).body(role).post(uri);
		
		assertThat(response.getStatusCode(), Matchers.equalTo(201));
		
	}
	
	
}

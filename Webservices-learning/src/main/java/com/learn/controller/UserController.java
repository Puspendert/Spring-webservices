package com.learn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learn.persistence.model.User;
import com.learn.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		System.out.println(userService);
		List<User> users = userService.findAll();	
		return users;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findOne(@PathVariable("id") final Long userId) {
		return userService.findOne(userId);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create( @RequestBody @Valid final User user) {
		userService.create(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void update( @PathVariable("id") final Long userId, @RequestBody final User user) {
		userService.update(userId, user);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public void delete(@PathVariable("id") final Long userId) {
		userService.delete(userId);
	}

}

package com.learn.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learn.persistence.model.Role;
import com.learn.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	private List<Role> findAll() {
		System.out.println(roleService);
		return roleService.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	private Role findOne(@PathVariable("id") final Long roleId) {
		return roleService.findOne(roleId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	@Secured("ROLE_ROLE_WRITE")
	public void create( @RequestBody @Valid final Role role) {
		roleService.createOneRole(role);
	}
}

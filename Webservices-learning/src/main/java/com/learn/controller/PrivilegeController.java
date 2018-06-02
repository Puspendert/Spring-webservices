package com.learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.persistence.model.Privilege;
import com.learn.service.PrivilegeService;

@RestController
@RequestMapping("/privileges")
public class PrivilegeController {

	@Autowired
	private PrivilegeService privilegeService;

	@RequestMapping(method = RequestMethod.GET)
	@Secured("ROLE_PRIVILEGE_READ")
	public List<Privilege> findAll() {
		return privilegeService.findAll();
	}

	@RequestMapping(value = "{/id}", method = RequestMethod.GET)
	public Privilege findOne(@PathVariable("id") final Long privId) {
		return privilegeService.findOne(privId);
	}

}

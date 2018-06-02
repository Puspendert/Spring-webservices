package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.persistence.dao.RoleJpaRepository;
import com.learn.persistence.model.Role;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleJpaRepository roleJpaRepository;
	
	public List<Role> findAll(){
		return roleJpaRepository.findAll();
	}
	
	public Role findOne(Long roleId) {
		return roleJpaRepository.getOne(roleId);
	}
	
	public void createOneRole(Role role) {
		roleJpaRepository.save(role);
	}

}

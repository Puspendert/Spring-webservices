package com.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.persistence.dao.PrivilegeJpaRepository;
import com.learn.persistence.model.Privilege;

@Service
@Transactional
public class PrivilegeService {

	@Autowired
	private PrivilegeJpaRepository privilegeJpaRepository;
	
	public List<Privilege> findAll(){
		return privilegeJpaRepository.findAll();
	}
	
	public Privilege findOne(Long privId) {
		return privilegeJpaRepository.getOne(privId);
	}
}

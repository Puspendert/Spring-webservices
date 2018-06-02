package com.learn.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.exceptions.MyBadRequestException;
import com.learn.persistence.dao.UserJpaRepository;
import com.learn.persistence.model.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	public List<User> findAll(){
		return userJpaRepository.findAll();
	}
	
	public User findOne(Long userId) {
		User user = userJpaRepository.getOne(userId);
		if(user.getName() != null) {}
		return user;
	}
	
	public void create(User user) {
		userJpaRepository.save(user);
	}
	
	public void update(Long userId,User user) {
		if(user.getUserId() != userId) 
			throw new MyBadRequestException(user.getClass().getSimpleName() + " id and URL id don't match");
		userJpaRepository.saveAndFlush(user);
	}

	public void delete(Long userId) {
		userJpaRepository.deleteById(userId);
	}
	
	public User findByEmail(String email) {
		return userJpaRepository.findByEmail(email);
	}
}

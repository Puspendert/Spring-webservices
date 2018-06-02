package com.learn.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.persistence.model.User;

public interface UserJpaRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
}

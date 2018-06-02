package com.learn.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.persistence.model.Role;

public interface RoleJpaRepository extends JpaRepository<Role, Long> {

}

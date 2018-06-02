package com.learn.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.persistence.model.Privilege;

public interface PrivilegeJpaRepository extends JpaRepository<Privilege, Long> {

}

package com.learn.persistence;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.learn.persistence.dao.RoleJpaRepository;
import com.learn.persistence.dao.UserJpaRepository;
import com.learn.persistence.model.Privilege;
import com.learn.persistence.model.Role;
import com.learn.persistence.model.User;
import com.learn.springConfig.ContextConfig;
import com.learn.springConfig.PersistenceJpaConfig;

@ContextConfiguration(classes = {PersistenceJpaConfig.class, ContextConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class TestJPA {

	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	private RoleJpaRepository roleJpaRepository;
	
	@Ignore
	@Test
	@Rollback(false)
	public void insertUsers() {
		//User user1 = new User("puspender3@fake.com","puspender3", false, "12345");
		//System.out.println("saving user");
		//assertNotNull(userJpaRepository.save(user1));
	}
	
	@Ignore
	@Test
	public void insertRole() {
		Role role1 = new Role("CONTENT_REVIEWER");
		System.out.println("savinf role");
		assertNotNull(roleJpaRepository.save(role1));
	}
	@Ignore
	@Test
	public void findAllUsers() {
		List<User> users = userJpaRepository.findAll();
		for(User user : users) {
			System.out.println(user.getName()+"\t"+ user.isLocked());
		}
	}
	
	@Test
	public void findOneUser() {
		User user = userJpaRepository.getOne(3L);
		Set<Role> roles = user.getRoles();
		for(Role role : roles) {
			System.out.println(role.getName());
		}
		Role role = roles.iterator().next();
		Set<Privilege> privileges = role.getPrivileges();
		for(Privilege privilege : privileges) {
			System.out.println(privilege.getName());
		}
		System.out.println(privileges.size());
		assertNotNull(user);
	}
	
}

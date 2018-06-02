package com.learn.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.learn.persistence.model.Privilege;
import com.learn.persistence.model.Role;
import com.learn.persistence.model.User;
import com.learn.service.UserService;

@Component
public class MyUserDetailService implements UserDetailsService {
 
	private Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("getting username {}", username);
		final User user = userService.findByEmail(username);
		logger.info("{}",user);
		if(user == null) {
			throw new UsernameNotFoundException("User Name not found: "+ username);
		}
		
		final Set<Role> userRoles = user.getRoles();
		final Set<Privilege> userPrivileges = new HashSet<>();
		
		for(Role role : userRoles) {
			userPrivileges.addAll(role.getPrivileges());
		}
		
		List<String> rolesForAuth = new ArrayList<>();
		
		for(Privilege privilege : userPrivileges) {
			rolesForAuth.add(privilege.getName());
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : rolesForAuth) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}

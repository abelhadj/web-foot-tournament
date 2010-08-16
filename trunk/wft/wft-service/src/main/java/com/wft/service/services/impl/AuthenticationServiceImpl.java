package com.wft.service.services.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.Authentication;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.context.SecurityContextImpl;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;

import com.wft.model.Project;
import com.wft.model.ReturnMemento;
import com.wft.model.user.Administrator;
import com.wft.model.user.User;
import com.wft.service.core.ICommonService;
import com.wft.service.core.impl.ServiceImpl;
import com.wft.service.services.AuthenticationService;
import com.wft.service.services.ProjectService;

/**
 * {@link AuthenticationService} implementation.
 * 
 */
public class AuthenticationServiceImpl extends ServiceImpl<User> implements
		AuthenticationService, ICommonService<User>, InitializingBean {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hakanai.services.AuthenticationService#authenticate(java.lang.String,
	 * java.lang.String)
	 */
	public ReturnMemento authenticate(String username, String password) {
		// create a test case where admin have ROLE_ADMIN and ROLE_USER
		if (username.equals("admin")) {
			// creating an authenticated user token for demo
			// regardless of username and password values
			GrantedAuthority[] authorities = new GrantedAuthority[] {
					new GrantedAuthorityImpl("ROLE_ADMINISTRATOR"),
					new GrantedAuthorityImpl("ROLE_USER") };
			org.springframework.security.userdetails.User user = new org.springframework.security.userdetails.User("xxx", "yyy", true, true, true, true,
					authorities);
			Authentication auth = new UsernamePasswordAuthenticationToken(user,
					password, authorities);
			SecurityContext sc = new SecurityContextImpl();
			sc.setAuthentication(auth);
			SecurityContextHolder.setContext(sc);

			return new ReturnMemento(ReturnMemento.CODE_SUCCESS,
					ReturnMemento.CODE_SUCCESS);
		}
		// user only have ROLE_USER
		else if (username.equals("user")) {
			// creating an authenticated user token for demo
			// regardless of username and password values
			GrantedAuthority[] authorities = new GrantedAuthority[] { new GrantedAuthorityImpl(
					"ROLE_USER") };
			org.springframework.security.userdetails.User user = new org.springframework.security.userdetails.User("xxx", "yyy", true, true, true, true,
					authorities);
			Authentication auth = new UsernamePasswordAuthenticationToken(user,
					password, authorities);
			SecurityContext sc = new SecurityContextImpl();
			sc.setAuthentication(auth);
			SecurityContextHolder.setContext(sc);

			return new ReturnMemento(ReturnMemento.CODE_SUCCESS,
					ReturnMemento.CODE_SUCCESS);
		}
		// other people can't log in
		else {
			ReturnMemento rm = new ReturnMemento(ReturnMemento.CODE_ERROR,
					ReturnMemento.CODE_ERROR);
			rm.getErrors().put("login", "login or password incorrect");
			rm.getErrors().put("password", "login or password incorrect");
			return rm;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hakanai.services.AuthenticationService#logout()
	 */
	public void logout() {
		SecurityContextHolder.clearContext();
	}

	public void afterPropertiesSet() throws Exception {
//		Administrator admin = new Administrator("admin", "admin");
		User user1 = new User("user1","user1");
		User user2 = new User("user2","user2");
//		this.getDao().add(admin);
		this.getDao().add(user1);
		this.getDao().add(user2);
	}

}

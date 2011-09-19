package com.wft.service.services;

import org.springframework.security.annotation.Secured;

import com.wft.model.ReturnMemento;
import com.wft.model.user.User;
import com.wft.service.core.ICommonService;

/**
 * Authentication service.
 * 
 */
public interface IAuthenticationService extends ICommonService<User>{

	/**
	 * Authenticates user.
	 * 
	 * @param username
	 * @param password
	 * @return whether authentication is successful
	 */
	ReturnMemento authenticate(String username, String password);

	/**
	 * Terminates a user's security session.
	 */
	@Secured("ROLE_USER")
	void logout();
}

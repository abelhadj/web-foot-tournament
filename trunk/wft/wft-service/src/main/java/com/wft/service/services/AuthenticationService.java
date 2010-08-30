package com.wft.service.services;

import com.wft.model.ReturnMemento;

/**
 * Authentication service.
 * 
 */
public interface AuthenticationService {

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
	void logout();
}

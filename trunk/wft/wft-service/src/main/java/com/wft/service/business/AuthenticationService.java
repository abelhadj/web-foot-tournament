package com.wft.service.business;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.wft.model.ReturnMemento;

/**
 * Authentication service.
 * 
 */
@RemoteServiceRelativePath("AuthenticationService.rpc")
public interface AuthenticationService extends RemoteService {

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

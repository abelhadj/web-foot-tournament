package com.wft.service.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.wft.model.ReturnMemento;

/**
 * Authentication service async interface.
 * 
 */
public interface AuthenticationServiceAsync {

	public void authenticate(String username, String password, AsyncCallback<ReturnMemento> callback);

	public void logout(AsyncCallback<Object> callback);
}

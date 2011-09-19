package com.wft.service.services;

import org.springframework.security.annotation.Secured;

import com.wft.model.user.Administrator;
import com.wft.model.user.User;
import com.wft.service.core.ICommonService;


public interface IUserService extends ICommonService<User> {
	
	User getCurrentlyConnected();

	void createNewUser(User user);
	
	void updateUser(Integer userId, User user);

	@Secured("ROLE_ORGANIZER")
	void banUser(User user);
}

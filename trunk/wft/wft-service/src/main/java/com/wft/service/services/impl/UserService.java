package com.wft.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.user.User;
import com.wft.service.core.ICommonService;
import com.wft.service.core.impl.ServiceImpl;
import com.wft.service.dao.IUserDAO;
import com.wft.service.services.IUserService;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserService extends ServiceImpl<User> implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	public User getCurrentlyConnected() {
		org.springframework.security.userdetails.User springUser = (org.springframework.security.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDAO.findByLogin(springUser.getUsername());
		return user;
	}

	public void createNewUser(User user) {
		// TODO Auto-generated method stub

	}

	public void updateUser(Integer userId, User user) {
		// TODO Auto-generated method stub

	}

	public void banUser(User user) {
		// TODO Auto-generated method stub

	}

}

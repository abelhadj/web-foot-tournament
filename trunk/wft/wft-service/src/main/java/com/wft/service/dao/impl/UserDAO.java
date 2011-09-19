package com.wft.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.user.User;
import com.wft.service.dao.IUserDAO;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class UserDAO extends BaseDaoHibernate<User> implements IUserDAO {

	public UserDAO() {
		super(User.class);
	}

	public User findByLogin(String login) {
		List<User> users = findByPropertyValue("login", login);
		if (users == null || users.size() <= 0)
			return null;
		return users.get(0);
	}
}

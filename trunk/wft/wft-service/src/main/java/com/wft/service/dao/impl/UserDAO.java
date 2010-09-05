package com.wft.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.user.User;
import com.wft.service.dao.IUserDAO;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class UserDAO extends BaseDaoHibernate <User> implements IUserDAO
{

    public UserDAO()
    {
        super(User.class);
    }

	public List<User> findByLogin(String login) {
		return findByPropertyValue("login", login);
	}
}

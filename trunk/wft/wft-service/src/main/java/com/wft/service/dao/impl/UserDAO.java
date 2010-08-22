package com.wft.service.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.wft.model.user.User;
import com.wft.service.dao.IUserDAO;

public class UserDAO extends BaseDaoHibernate <User> implements IUserDAO
{

    public UserDAO(Class<User> _type)
    {
        super(_type);
    }

	public List<User> findByLogin(String login) {
		return findByPropertyValue("login", login);
	}
}

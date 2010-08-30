package com.wft.service.dao;

import java.util.List;

import com.wft.model.user.User;

public interface IUserDAO extends IDao<User>
{
	public List<User> findByLogin(String login);
}

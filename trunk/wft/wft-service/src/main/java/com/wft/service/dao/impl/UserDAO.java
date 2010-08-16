package com.wft.service.dao.impl;

import com.wft.model.user.User;
import com.wft.service.dao.IUserDAO;

public class UserDAO extends BaseDaoHibernate <User> implements IUserDAO
{

    public UserDAO(Class<User> _type)
    {
        super(_type);
    }
}

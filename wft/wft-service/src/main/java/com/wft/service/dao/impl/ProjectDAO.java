package com.wft.service.dao.impl;

import com.wft.model.Project;
import com.wft.service.dao.IProjectDAO;

public class ProjectDAO extends BaseDaoHibernate <Project> implements IProjectDAO
{

    public ProjectDAO(Class<Project> _type)
    {
        super(_type);
    }
}

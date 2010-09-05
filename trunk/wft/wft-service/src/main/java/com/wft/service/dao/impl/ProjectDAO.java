package com.wft.service.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.Project;
import com.wft.service.dao.IProjectDAO;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class ProjectDAO extends BaseDaoHibernate <Project> implements IProjectDAO
{
	
	public ProjectDAO ()
	{
		super(Project.class);
	}

}

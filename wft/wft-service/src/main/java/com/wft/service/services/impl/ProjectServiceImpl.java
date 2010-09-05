package com.wft.service.services.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.Project;
import com.wft.service.core.ICommonService;
import com.wft.service.core.impl.ServiceImpl;
import com.wft.service.dao.IProjectDAO;
import com.wft.service.services.ProjectService;

/**
 * Service implementation
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProjectServiceImpl extends ServiceImpl< Project> implements ProjectService , ICommonService<Project>, InitializingBean
{
	@Autowired
	private IProjectDAO projectDAO;
	
	public void afterPropertiesSet() throws Exception {
		this.dao = projectDAO;
	}

}
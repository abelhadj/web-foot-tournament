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
import com.wft.service.services.IProjectService;

/**
 * Service implementation
 */
@Service("projectService")
@Transactional(propagation = Propagation.REQUIRED)
public class ProjectService extends ServiceImpl< Project> implements IProjectService, InitializingBean
{
	@Autowired
	private IProjectDAO projectDAO;
	
	public void afterPropertiesSet() throws Exception {
		this.dao = projectDAO;
	}

}
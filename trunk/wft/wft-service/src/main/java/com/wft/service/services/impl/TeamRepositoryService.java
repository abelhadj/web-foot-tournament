package com.wft.service.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.team.Team;
import com.wft.model.team.TeamRepository;
import com.wft.service.core.ICommonService;
import com.wft.service.core.impl.ServiceImpl;
import com.wft.service.dao.ITeamRepositoryDAO;
import com.wft.service.services.ITeamRepositoryService;

@Service("teamRepositoryService")
@Transactional(propagation = Propagation.REQUIRED)
public class TeamRepositoryService extends ServiceImpl<TeamRepository> implements ITeamRepositoryService, InitializingBean, ApplicationContextAware {

	@Autowired
	private ITeamRepositoryDAO teamRepositoryDAO;

	public void afterPropertiesSet() throws Exception {
		if (CollectionUtils.isEmpty(this.teamRepositoryDAO.findAll())) {
			for (TeamRepository repo : InitTeamRepositoryFeeder.getData()) {
				this.teamRepositoryDAO.add(repo);
			}
		}
	}

	public List<String> getAllRepositoriesName() {
		List<String> result = new LinkedList<String>();
		for (TeamRepository teamRepo : this.teamRepositoryDAO.findAll()) {
			result.add(teamRepo.getName());
		}
		return result;
	}

	public TeamRepository getTeamRepositoryByName(String repositoryName) {
		List<TeamRepository> list = this.teamRepositoryDAO.findByPropertyValue("name", repositoryName);
		return list.isEmpty() ? null : list.get(0);
	}

	private ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

}

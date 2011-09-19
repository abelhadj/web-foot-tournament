package com.wft.service.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.team.TeamRepository;
import com.wft.service.dao.ITeamRepositoryDAO;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class TeamRepositoryDAO extends BaseDaoHibernate<TeamRepository> implements
		ITeamRepositoryDAO {

	public TeamRepositoryDAO() {
		super(TeamRepository.class);
	}

}

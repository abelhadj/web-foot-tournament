package com.wft.service.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.tournament.GamingTeam;
import com.wft.service.dao.IGamingTeamDAO;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class GamingTeamDAO extends BaseDaoHibernate<GamingTeam> implements
		IGamingTeamDAO {

	public GamingTeamDAO() {
		super(GamingTeam.class);
	}

}

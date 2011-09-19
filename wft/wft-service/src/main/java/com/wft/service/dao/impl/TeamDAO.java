package com.wft.service.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.team.Team;
import com.wft.model.user.User;
import com.wft.service.dao.ITeamDAO;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class TeamDAO extends BaseDaoHibernate<Team> implements
		ITeamDAO {

	public TeamDAO() {
		super(Team.class);
	}

	public Team findByName(String name) {
		List<Team> teams = findByPropertyValue("name", name);
		if (teams == null || teams.size() <= 0)
			return null;
		return teams.get(0);
	}

}

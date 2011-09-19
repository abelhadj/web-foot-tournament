package com.wft.service.dao;

import com.wft.model.team.Team;

public interface ITeamDAO extends IDao<Team> {
	public Team findByName(String name);
}

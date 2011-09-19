package com.wft.service.services;

import java.util.List;

import com.wft.model.team.Team;
import com.wft.model.team.TeamRepository;
import com.wft.service.core.ICommonService;

public interface ITeamRepositoryService extends ICommonService<TeamRepository> {
	
	public List<String> getAllRepositoriesName();
	
	public TeamRepository getTeamRepositoryByName(String repositoryName);

}

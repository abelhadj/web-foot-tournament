package com.wft.service.services.impl;

import java.util.LinkedList;
import java.util.List;

import com.wft.model.team.Team;
import com.wft.model.team.TeamRepository;
import com.wft.model.team.TeamType;

public class InitTeamRepositoryFeeder {

	public static List<TeamRepository> getData() {
		List<TeamRepository> result = new LinkedList<TeamRepository>();

		TeamRepository teamRepo = new TeamRepository("Ligue 1", TeamType.CLUB);
		teamRepo.getAvailableTeams().add(new Team("L.O.S.C", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("O.M.", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("O.L.", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("P.S.G.", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Rennes", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Sochaux", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Girondins de Bordeaux", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Saint-Etienne", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Lorient", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Auxerre", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Brest", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Valenciennes", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Toulouse", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Caen", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Nancy", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Valenciennes", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("O.G.G Nice", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("A.S. Monaco", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("RC Lens", TeamType.CLUB));
		teamRepo.getAvailableTeams().add(new Team("Arles-Avignon", TeamType.CLUB));
		
		result.add(teamRepo);

		return result;
	}
}

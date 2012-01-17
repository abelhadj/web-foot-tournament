package com.wft.service.services.impl;

import java.util.LinkedList;
import java.util.List;

import com.wft.model.team.Team;
import com.wft.model.team.TeamRepository;
import com.wft.model.team.TeamType;

public class InitTeamRepositoryFeeder {

	private static final String LIGUE_1 = "Ligue 1";

  public static List<TeamRepository> getData() {
		List<TeamRepository> result = new LinkedList<TeamRepository>();

		TeamRepository teamRepo = new TeamRepository(LIGUE_1, TeamType.CLUB);
		teamRepo.getAvailableTeams().add(new Team("L.O.S.C", TeamType.CLUB, "/img/"+LIGUE_1+"/1.png"));
		teamRepo.getAvailableTeams().add(new Team("O.M.", TeamType.CLUB, "/img/"+LIGUE_1+"/2.png"));
		teamRepo.getAvailableTeams().add(new Team("O.L.", TeamType.CLUB, "/img/"+LIGUE_1+"/3.png"));
		teamRepo.getAvailableTeams().add(new Team("P.S.G.", TeamType.CLUB, "/img/"+LIGUE_1+"/4.png"));
    teamRepo.getAvailableTeams().add(new Team("Sochaux", TeamType.CLUB, "/img/"+LIGUE_1+"/5.png"));
		teamRepo.getAvailableTeams().add(new Team("Rennes", TeamType.CLUB, "/img/"+LIGUE_1+"/6.png"));
		teamRepo.getAvailableTeams().add(new Team("Girondins de Bordeaux", TeamType.CLUB, "/img/"+LIGUE_1+"/7.png"));
    teamRepo.getAvailableTeams().add(new Team("Toulouse", TeamType.CLUB, "/img/"+LIGUE_1+"/8.png"));
    teamRepo.getAvailableTeams().add(new Team("Auxerre", TeamType.CLUB, "/img/"+LIGUE_1+"/9.png"));
		teamRepo.getAvailableTeams().add(new Team("Saint-Etienne", TeamType.CLUB, "/img/"+LIGUE_1+"/10.png"));
		teamRepo.getAvailableTeams().add(new Team("Lorient", TeamType.CLUB, "/img/"+LIGUE_1+"/11.png"));
		teamRepo.getAvailableTeams().add(new Team("Valenciennes", TeamType.CLUB, "/img/"+LIGUE_1+"/12.png"));
    teamRepo.getAvailableTeams().add(new Team("Nancy", TeamType.CLUB, "/img/"+LIGUE_1+"/13.png"));
		teamRepo.getAvailableTeams().add(new Team("Montpellier", TeamType.CLUB, "/img/"+LIGUE_1+"/14.png"));
		teamRepo.getAvailableTeams().add(new Team("Caen", TeamType.CLUB, "/img/"+LIGUE_1+"/15.png"));
    teamRepo.getAvailableTeams().add(new Team("Brest", TeamType.CLUB, "/img/"+LIGUE_1+"/16.png"));
		teamRepo.getAvailableTeams().add(new Team("O.G.C. Nice", TeamType.CLUB, "/img/"+LIGUE_1+"/17.png"));
		teamRepo.getAvailableTeams().add(new Team("A.S. Monaco", TeamType.CLUB, "/img/"+LIGUE_1+"/18.png"));
		teamRepo.getAvailableTeams().add(new Team("RC Lens", TeamType.CLUB, "/img/"+LIGUE_1+"/19.png"));
		teamRepo.getAvailableTeams().add(new Team("Arles-Avignon", TeamType.CLUB, "/img/"+LIGUE_1+"/20.png"));
		
		result.add(teamRepo);

		return result;
	}
}

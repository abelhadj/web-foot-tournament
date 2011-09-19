package com.wft.service.services;

import java.util.List;

import org.springframework.security.annotation.Secured;

import com.wft.model.team.Team;
import com.wft.model.tournament.GamingRequest;
import com.wft.model.tournament.Tournament;
import com.wft.model.tournament.championship.Championship;
import com.wft.model.tournament.simplecup.SimpleCup;
import com.wft.model.user.Organizer;
import com.wft.service.core.ICommonService;

public interface ITournamentService extends ICommonService<Tournament> {
	@Secured("ROLE_ORGANIZER")
	SimpleCup createSimpleCup(Organizer organizer, int nbTeams, String teamRepositoryName);

	@Secured("ROLE_ORGANIZER")
	Championship createChampionship(Organizer organizer, int nbTeams, String teamRepositoryName);

	@Secured("ROLE_ORGANIZER")
	Tournament autoAssignUnassignedTeams(Tournament tournament);

	@Secured("ROLE_ORGANIZER")
	Tournament retrieveTournamentById(Integer tournamentId);

	@Secured("ROLE_USER")
	List<Tournament> getAllTournamentsForUser();

	@Secured("ROLE_USER")
	void requestToPlayInTournament(Tournament tournament, Team team);
	@Secured("ROLE_ORGANIZER")
	List<GamingRequest> getAllPlayingRequests();
	@Secured("ROLE_ORGANIZER")
	void acceptRequestToPlayInTournament(GamingRequest gamingRequest);

}

package com.wft.service.services;

import java.util.List;

import org.springframework.security.annotation.Secured;

import com.wft.model.team.Team;
import com.wft.model.tournament.PlayingRequest;
import com.wft.model.tournament.Tournament;
import com.wft.model.user.Organizer;
import com.wft.model.user.User;

public interface TournamentService {
	@Secured("ROLE_USER")
	void createNewTournament(Tournament tournament);

	@Secured("ROLE_USER")
	List<Tournament> getAllTournamentsForUser();

	@Secured("ROLE_USER")
	void requestToPlayInTournament(Tournament tournament, Team team);
	@Secured("ROLE_ORGANIZER")
	List<PlayingRequest> getAllPlayingRequests();
	@Secured("ROLE_ORGANIZER")
	void acceptRequestToPlayInTournament(PlayingRequest playingRequest);



}

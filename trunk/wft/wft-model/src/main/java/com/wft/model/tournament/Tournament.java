package com.wft.model.tournament;

import java.util.Collection;

import com.wft.model.user.Organizer;

public abstract class Tournament {

	private Organizer organizer;
	
	public abstract Collection<PlayingTeam> getPlayingTeams();
}

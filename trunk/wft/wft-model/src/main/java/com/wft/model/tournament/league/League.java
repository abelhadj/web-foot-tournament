package com.wft.model.tournament.league;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForceDiscriminator;

import com.wft.model.tournament.PlayingTeam;
import com.wft.model.tournament.Tournament;
import com.wft.model.tournament.game.Game;

@Entity
@DiscriminatorValue(value = "LEAGUE")
@ForceDiscriminator
public class League extends Tournament {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<PlayingTeam> playingTeams;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Game> games;

	@Override
	public List<PlayingTeam> getPlayingTeams() {
		return playingTeams;
	}

	@Override
	public List<Game> getGames() {
		return games;
	}

}

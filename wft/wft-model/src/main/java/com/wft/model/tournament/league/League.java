package com.wft.model.tournament.league;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import com.wft.model.BaseEntity;
import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.game.Game;

@Entity
public class League extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean twoGamesPerConfrontation;

	private Integer pointsPerVictory = 3;
	private Integer pointsPerTie = 1;
	private Integer pointsPerDefeat = 0;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Map<GamingTeam,LeagueTeamStats> gamingTeamsStats = new HashMap<GamingTeam,LeagueTeamStats>();
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Game> gamesPlayed = new LinkedList<Game>();

	public Boolean getTwoGamesPerConfrontation() {
		return twoGamesPerConfrontation;
	}

	public void setTwoGamesPerConfrontation(Boolean twoGamesPerConfrontation) {
		this.twoGamesPerConfrontation = twoGamesPerConfrontation;
	}

	public Integer getPointsPerVictory() {
		return pointsPerVictory;
	}

	public void setPointsPerVictory(Integer pointsPerVictory) {
		this.pointsPerVictory = pointsPerVictory;
	}

	public Integer getPointsPerTie() {
		return pointsPerTie;
	}

	public void setPointsPerTie(Integer pointsPerTie) {
		this.pointsPerTie = pointsPerTie;
	}

	public Integer getPointsPerDefeat() {
		return pointsPerDefeat;
	}

	public void setPointsPerDefeat(Integer pointsPerDefeat) {
		this.pointsPerDefeat = pointsPerDefeat;
	}

	public Map<GamingTeam, LeagueTeamStats> getGamingTeamsStats() {
		return gamingTeamsStats;
	}

	public List<Game> getGamesPlayed() {
		return gamesPlayed;
	}
	
	
	
}

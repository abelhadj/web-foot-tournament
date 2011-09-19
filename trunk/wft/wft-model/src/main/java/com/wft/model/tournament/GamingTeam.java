package com.wft.model.tournament;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.wft.model.BaseEntity;
import com.wft.model.team.Team;
import com.wft.model.tournament.game.Game;
import com.wft.model.user.Gamer;

@Entity
public class GamingTeam extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private Team team;

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private Gamer gamer;

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Game> gamesHistory;

	public GamingTeam() {
		super();
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}

	public List<Game> getGamesHistory() {
		return gamesHistory;
	}

	public void setGamesHistory(List<Game> gamesHistory) {
		this.gamesHistory = gamesHistory;
	}

	
}

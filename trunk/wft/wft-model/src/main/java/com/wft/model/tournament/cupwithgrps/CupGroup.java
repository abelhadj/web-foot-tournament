package com.wft.model.tournament.cupwithgrps;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.wft.model.BaseEntity;
import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.league.League;

@Entity
public class CupGroup extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer groupNumber;
	

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private League league;

	public Set<GamingTeam> getPlayingTeams() {
		return league.getGamingTeamsStats().keySet();
	}

}

package com.wft.model.tournament.championship;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ForceDiscriminator;

import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.Tournament;
import com.wft.model.tournament.league.League;

@Entity
@DiscriminatorValue(value = "CHAMPIONSHIP")
@ForceDiscriminator
public class Championship extends Tournament {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private League league;

	@Override
	public Set<GamingTeam> getGamingTeamsReadOnly() {
		return league.getGamingTeamsStats().keySet();
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
	
}

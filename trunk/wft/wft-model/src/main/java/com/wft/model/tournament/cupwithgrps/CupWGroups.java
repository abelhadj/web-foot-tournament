package com.wft.model.tournament.cupwithgrps;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.ForceDiscriminator;

import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.Tournament;

@Entity
@DiscriminatorValue(value = "CUP_WITH_GROUPS")
@ForceDiscriminator
public class CupWGroups extends Tournament {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@OrderBy(value="groupNumber ASC")
	private List<CupGroup> cupGroups;
	
	@Override
	public Set<GamingTeam> getGamingTeamsReadOnly() {
		Set<GamingTeam> gamingTeams = new HashSet<GamingTeam>();
		for (CupGroup cupGroup : cupGroups) {
			gamingTeams.addAll(cupGroup.getPlayingTeams());
		}
		return gamingTeams;
	}

}

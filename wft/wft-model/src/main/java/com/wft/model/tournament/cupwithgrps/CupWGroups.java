package com.wft.model.tournament.cupwithgrps;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.ForceDiscriminator;

import com.wft.model.tournament.PlayingTeam;
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
	public List<PlayingTeam> getPlayingTeams() {
		List<PlayingTeam> playingTeams = new LinkedList<PlayingTeam>();
		for (CupGroup cupGroup : cupGroups) {
			playingTeams.addAll(cupGroup.getPlayingTeams());
		}
		return playingTeams;
	}

}

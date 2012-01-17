package com.wft.model.tournament;

import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ForceDiscriminator;

import com.wft.model.BaseEntity;
import com.wft.model.user.Organizer;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING, columnDefinition = "VARCHAR(32) DEFAULT \"TOURNAMENT\"", length = 32)
@DiscriminatorValue(value = "TOURNAMENT")
@ForceDiscriminator
public abstract class Tournament extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {})
	private List<Organizer> organizers;

	private Boolean autoAcceptPlayers;
	
	private String teamRepoName;

	public List<Organizer> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(List<Organizer> organizers) {
		this.organizers = organizers;
	}

	public Boolean getAutoAcceptPlayers() {
		return autoAcceptPlayers;
	}

	public void setAutoAcceptPlayers(Boolean autoAcceptPlayers) {
		this.autoAcceptPlayers = autoAcceptPlayers;
	}

	public String getTeamRepoName() {
		return teamRepoName;
	}

	public void setTeamRepoName(String teamRepoName) {
		this.teamRepoName = teamRepoName;
	}

	public String getCategory() {
	  return this.getClass().getName();
	}
	
	public abstract Set<GamingTeam> getGamingTeamsReadOnly();
	
	
}

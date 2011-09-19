package com.wft.model.team;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.wft.model.BaseEntity;

@Entity
public class TeamRepository extends BaseEntity{
	public TeamRepository(String name, TeamType type) {
		super();
		this.name = name;
		this.type = type;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeamRepository() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String name;
	
	private TeamType type;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@OrderBy(value="name ASC")
	private List<Team> availableTeams = new LinkedList<Team>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeamType getType() {
		return type;
	}

	public void setType(TeamType type) {
		this.type = type;
	}

	public List<Team> getAvailableTeams() {
		return availableTeams;
	}

	public void setAvailableTeams(List<Team> availableTeams) {
		this.availableTeams = availableTeams;
	}

}

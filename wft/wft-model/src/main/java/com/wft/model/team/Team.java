package com.wft.model.team;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.wft.model.BaseEntity;

@Entity
public class Team extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
//	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TeamType type;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<TeamPlayer> players = new LinkedList<TeamPlayer>();

	public static final String UNASSIGNED_TEAM_NAME = "<UNASSIGNED>";

	
	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(String name, TeamType type) {
		super();
		this.name = name;
		this.type = type;
	}

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

	public List<TeamPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(List<TeamPlayer> players) {
		this.players = players;
	}

	
	
}

package com.wft.model.tournament.league;

import javax.persistence.Entity;

import com.wft.model.BaseEntity;

@Entity
public class LeagueTeamStats extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer nbGamesPlayed;
	private Integer nbVictories;
	private Integer nbTies;
	private Integer nbDefeats;
	private Integer goalsScored;
	private Integer goalsTaken;
	private Integer points;
	private Integer goalAverage;
	
	public void clearStats() {
		nbGamesPlayed = 0;
		nbVictories = 0;
		nbTies = 0;
		nbDefeats = 0;
		goalsScored = 0;
		goalsTaken = 0;
		goalAverage = 0;
	}

	public Integer getNbGamesPlayed() {
		return nbGamesPlayed;
	}
	public void setNbGamesPlayed(Integer nbGamesPlayed) {
		this.nbGamesPlayed = nbGamesPlayed;
	}
	public Integer getNbVictories() {
		return nbVictories;
	}
	public void setNbVictories(Integer nbVictories) {
		this.nbVictories = nbVictories;
	}
	public Integer getNbTies() {
		return nbTies;
	}
	public void setNbTies(Integer nbTies) {
		this.nbTies = nbTies;
	}
	public Integer getNbDefeats() {
		return nbDefeats;
	}
	public void setNbDefeats(Integer nbDefeats) {
		this.nbDefeats = nbDefeats;
	}
	public Integer getGoalsScored() {
		return goalsScored;
	}
	public void setGoalsScored(Integer goalsScored) {
		this.goalsScored = goalsScored;
	}
	public Integer getGoalsTaken() {
		return goalsTaken;
	}
	public void setGoalsTaken(Integer goalsTaken) {
		this.goalsTaken = goalsTaken;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getGoalAverage() {
		return goalAverage;
	}

	public void setGoalAverage(Integer goalAverage) {
		this.goalAverage = goalAverage;
	}
	
}

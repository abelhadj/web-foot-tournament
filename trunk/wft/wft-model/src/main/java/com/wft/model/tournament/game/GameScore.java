package com.wft.model.tournament.game;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.wft.model.BaseEntity;
import com.wft.model.team.TeamPlayer;

@Entity
public class GameScore extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer hostingScore;

	private Integer visitorScore;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<TeamPlayer> hostingScorers;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<TeamPlayer> visitorScorers;

	public Integer getHostingScore() {
		return hostingScore;
	}

	public void setHostingScore(Integer hostingScore) {
		this.hostingScore = hostingScore;
	}

	public Integer getVisitorScore() {
		return visitorScore;
	}

	public void setVisitorScore(Integer visitorScore) {
		this.visitorScore = visitorScore;
	}
	
	public ScoreType getType() {
		if (hostingScore>visitorScore) {
			return ScoreType.VICTORY;
		} else if (hostingScore<visitorScore) {
			return ScoreType.DEFEAT;
		}
		return ScoreType.TIE;
	}

	public enum ScoreType {
		VICTORY,
		TIE,
		DEFEAT
	}
}

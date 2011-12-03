package com.wft.model.tournament.game;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.wft.model.BaseEntity;
import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.Tournament;

@Entity
public class Game extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private Tournament tournament;
	
	private Boolean played;

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private GamingTeam hostingTeam;

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private GamingTeam visitorTeam;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private GameScore finalScore;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private GameScore halfTimeScore;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private GameScore penaltyKicksScore;

	public GamingTeam getHostingTeam() {
		return hostingTeam;
	}

	public void setHostingTeam(GamingTeam hostingTeam) {
		this.hostingTeam = hostingTeam;
	}

	public GamingTeam getVisitorTeam() {
		return visitorTeam;
	}

	public void setVisitorTeam(GamingTeam visitorTeam) {
		this.visitorTeam = visitorTeam;
	}

	public GameScore getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(GameScore finalScore) {
		this.finalScore = finalScore;
	}

	public GameScore getHalfTimeScore() {
		return halfTimeScore;
	}

	public void setHalfTimeScore(GameScore halfTimeScore) {
		this.halfTimeScore = halfTimeScore;
	}

	public GameScore getPenaltyKicksScore() {
		return penaltyKicksScore;
	}

	public void setPenaltyKicksScore(GameScore penaltyKicksScore) {
		this.penaltyKicksScore = penaltyKicksScore;
	}

	public Boolean getPlayed() {
		return played;
	}

	public void setPlayed(Boolean played) {
		this.played = played;
	}

  public boolean isALeafGame() {
    return this.getPlayed() && this.getVisitorTeam() == null;
  }

	
}

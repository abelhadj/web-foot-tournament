package com.wft.model.tournament.simplecup;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.wft.model.BaseEntity;
import com.wft.model.tournament.game.Game;

@Entity
public class CupNode extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Game nodeGame;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private CupNode hostingPreviouslyWonNode;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private CupNode visitorPreviouslyWonNode;

	public Game getNodeGame() {
		return nodeGame;
	}
	public void setNodeGame(Game nodeGame) {
		this.nodeGame = nodeGame;
	}
	public CupNode getHostingPreviouslyWonNode() {
		return hostingPreviouslyWonNode;
	}
	public void setHostingPreviouslyWonNode(CupNode hostingPreviouslyWonNode) {
		this.hostingPreviouslyWonNode = hostingPreviouslyWonNode;
	}
	public CupNode getVisitorPreviouslyWonNode() {
		return visitorPreviouslyWonNode;
	}
	public void setVisitorPreviouslyWonNode(CupNode visitorPreviouslyWonNode) {
		this.visitorPreviouslyWonNode = visitorPreviouslyWonNode;
	}

	
}

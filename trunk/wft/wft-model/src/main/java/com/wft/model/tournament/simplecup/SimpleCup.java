package com.wft.model.tournament.simplecup;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ForceDiscriminator;

import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.Tournament;

@Entity
@DiscriminatorValue(value = "SIMPLE_CUP")
@ForceDiscriminator
public class SimpleCup extends Tournament {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private CupNode finalCupNode;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private CupNode thirdPlaceCupNode;

	public CupNode getFinalCupNode() {
		return finalCupNode;
	}

	public void setFinalCupNode(CupNode finalCupNode) {
		this.finalCupNode = finalCupNode;
	}

	public CupNode getThirdPlaceCupNode() {
		return thirdPlaceCupNode;
	}

	public void setThirdPlaceCupNode(CupNode thirdPlaceCupNode) {
		this.thirdPlaceCupNode = thirdPlaceCupNode;
	}

	@Override
	public Set<GamingTeam> getGamingTeamsReadOnly() {
		// TODO
		return null;
	}

}

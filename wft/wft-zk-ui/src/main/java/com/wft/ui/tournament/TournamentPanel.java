package com.wft.ui.tournament;

import org.zkoss.zul.Panel;

import com.wft.model.tournament.Tournament;
import com.wft.model.tournament.simplecup.SimpleCup;

public class TournamentPanel extends Panel {

	public TournamentPanel(Tournament tournament) {
		super();
		if (tournament instanceof SimpleCup) {
			displaySimpleCup((SimpleCup)tournament);
		}
	}

	private void displaySimpleCup(SimpleCup tournament) {
//		this.appendChild();
	}

	
}

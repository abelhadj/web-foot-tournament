package com.wft.ui.tournament;

import java.util.Vector;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkmax.zul.Tablelayout;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;

import com.wft.model.tournament.Tournament;
import com.wft.model.tournament.championship.Championship;
import com.wft.model.tournament.simplecup.SimpleCup;

public class TournamentPanel extends Panel {

	private Tablelayout tableLayout;
	private Vector<Panel> panels;

	public TournamentPanel(Tournament tournament) {
		super();
		if (tournament instanceof SimpleCup) {
			displaySimpleCup((SimpleCup)tournament);
		} else if (tournament instanceof Championship) {
		  displayChampionshio((Championship) tournament);
		}
	}

	private void displaySimpleCup(SimpleCup simpleCup) {	
		Panelchildren child = new Panelchildren();
		child.appendChild(new SimpleCupUI(simpleCup));
		this.appendChild(child);
	}

  private void displayChampionshio(Championship championship) {  
    Panelchildren child = new Panelchildren();
    child.appendChild(new ChampionshipUI(championship));
    this.appendChild(child);
  }

	
}

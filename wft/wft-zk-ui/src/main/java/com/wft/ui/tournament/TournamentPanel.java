package com.wft.ui.tournament;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zkmax.zul.Tablechildren;
import org.zkoss.zkmax.zul.Tablelayout;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;

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
		Panelchildren child = new Panelchildren();
		Tablelayout tableLayout = new Tablelayout();
		
		tableLayout.setColumns(1);
		
		Tablechildren tablechildren = new Tablechildren();
		Panel panel = new Panel();
		tablechildren.appendChild(panel);
		Panelchildren panelchildren = new Panelchildren();
		panel.appendChild(panelchildren);

		Component game = Executions.createComponents("/app/tournament/game.zul", panelchildren, null);
		panelchildren.appendChild(game);
		
		tableLayout.appendChild(tablechildren);
		child.appendChild(tableLayout);
		
		this.appendChild(child);
	}


	
}

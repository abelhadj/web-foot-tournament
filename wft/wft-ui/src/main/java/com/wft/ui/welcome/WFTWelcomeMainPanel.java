package com.wft.ui.welcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.wft.model.tournament.Tournament;
import com.wft.model.tournament.championship.Championship;
import com.wft.model.tournament.simplecup.SimpleCup;
import com.wft.service.services.ITournamentService;
import com.wft.service.services.IUserService;
import com.wft.ui.tournament.WChampionship;
import com.wft.ui.tournament.WSimpleCup;

@org.springframework.stereotype.Component(value = "wftWelcomeMainPanel")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WFTWelcomeMainPanel extends Panel {
	
	public WFTWelcomeMainPanel() {
		super("Ecran principal");
		
		this.setScrollable(true);
		this.getContent().setSizeUndefined();
		this.setHeight(80, Sizeable.UNITS_PERCENTAGE);
	}

	public void refreshWithComponent(Component c) {
		this.removeAllComponents();
		this.addComponent(c);
	}
	
	public void displayTournament(Tournament t) {
		if (t instanceof SimpleCup) {
			this.refreshWithComponent(new WSimpleCup((SimpleCup) t));
		} else if (t instanceof Championship) {
			this.refreshWithComponent(new WChampionship((Championship) t));
		}
		
	}
	
}

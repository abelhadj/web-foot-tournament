package com.wft.ui.tournament;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.BaseTheme;
import com.vaadin.ui.themes.Reindeer;
import com.wft.model.tournament.championship.Championship;
import com.wft.model.tournament.game.Game;
import com.wft.model.tournament.simplecup.CupNode;
import com.wft.model.tournament.simplecup.SimpleCup;
import com.wft.service.services.ITournamentService;
import com.wft.ui.tournament.game.WGame;
import com.wft.ui.tournament.game.WLeagueTeamsStats;
import com.wft.util.ApplicationHolder;
import com.wft.util.WFTUIHelper;

public class WChampionship extends Panel {

	private Championship championship;

	private static Log logger = LogFactory.getLog(WChampionship.class);

	private transient ITournamentService iTournamentService = WFTUIHelper.getApplicationServiceProvider().getTournamentService();

	public WChampionship(Championship championship) {
		super();
		this.championship = championship;
		initializeContent(championship);
		this.setScrollable(true);
		this.setHeight(75, Sizeable.UNITS_PERCENTAGE);
		this.setWidth(100, Sizeable.UNITS_PERCENTAGE);
	}

	private void initializeContent(Championship championship) {

		VerticalLayout lay = new VerticalLayout();

		Button b = new Button("Auto assign");
		lay.addComponent(b);

		final WChampionship finalThis = this;
		b.addListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				WChampionship.this.championship = (Championship) iTournamentService
						.autoAssignUnassignedTeams(WChampionship.this.championship);
				
				finalThis.initializeContent(WChampionship.this.championship);
			}
		});

		lay.addComponent(new WLeagueTeamsStats(championship.getLeague()));
		this.setContent(lay);
	}

}

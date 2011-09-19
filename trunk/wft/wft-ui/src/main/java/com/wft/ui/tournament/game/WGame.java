package com.wft.ui.tournament.game;

import com.vaadin.ui.Table;
import com.wft.model.tournament.game.Game;

public class WGame extends Table {

	final private Game game;

	// private static final int ROW_HEIGHT = 21;
	// private static final int ROW_WIDTH = 200;

	public WGame(Game game) {
		super();
		this.game = game;
		// this.setRowHeaderMode(ROW_HEADER_MODE_HIDDEN);
		// this.setColumnHeaderMode(COLUMN_HEADER_MODE_HIDDEN);
		// this.setHeight(2 * ROW_HEIGHT, Sizeable.UNITS_PIXELS);
		// this.setWidth(ROW_WIDTH, Sizeable.UNITS_PIXELS);

		this.setSelectable(true);

		this.addContainerProperty("Team", String.class, "-");
		this.addContainerProperty("Score", String.class, "-");

		this.setColumnHeaders(new String[] { "Team", "Score" });
		this.setRowHeaderMode(Table.ROW_HEADER_MODE_ICON_ONLY);

		initializeContent(game);
		this.setPageLength(2);

	}

	private void initializeContent(Game game) {
		// VerticalLayout lay = new VerticalLayout();
		//
		String hostingTeamName = null;
		String visitorTeamName = null;

		if (game != null) {
			hostingTeamName = (game.getHostingTeam() != null ? game
					.getHostingTeam().getTeam().getName() : "-");
			visitorTeamName = (game.getVisitorTeam() != null ? game
					.getVisitorTeam().getTeam().getName() : "-");
		}
		//
		// lay.addComponent(new Label(hostingTeamName));
		// lay.addComponent(new Label(visitorTeamName));
		//
		// this.setContent(lay);

		this.addItem(new Object[] { hostingTeamName, "2" }, 1);
		this.addItem(new Object[] { visitorTeamName, "1" }, 2);
		
	}
}

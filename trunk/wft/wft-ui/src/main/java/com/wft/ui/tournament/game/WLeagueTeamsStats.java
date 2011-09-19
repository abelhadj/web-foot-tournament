package com.wft.ui.tournament.game;

import com.vaadin.ui.Table;
import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.league.League;
import com.wft.model.tournament.league.LeagueTeamStats;

public class WLeagueTeamsStats extends Table {

	private League league;

	// private static final int ROW_HEIGHT = 21;
	// private static final int ROW_WIDTH = 200;

	public WLeagueTeamsStats(League league) {
		super();
		this.league = league;

		// private Integer nbGamesPlayed;
		// private Integer nbVictories;
		// private Integer nbTies;
		// private Integer nbDefeats;
		// private Integer goalsScored;
		// private Integer goalsTaken;

		this.setSelectable(true);

		this.addContainerProperty("Team name", String.class, "-");
		this.addContainerProperty("Points", String.class, "-");
		this.addContainerProperty("Played", String.class, "-");
		this.addContainerProperty("Victories", String.class, "-");
		this.addContainerProperty("Ties", String.class, "-");
		this.addContainerProperty("Defeats", String.class, "-");
		this.addContainerProperty("G. scored", String.class, "-");
		this.addContainerProperty("G. taken", String.class, "-");
		this.addContainerProperty("G. average", String.class, "-");

		this.setColumnHeaders(new String[] { "Team name", "Points", "Played",
				"Victories", "Ties", "Defeats", "G. scored", "G. taken",
				"G. average" });
		this.setRowHeaderMode(Table.ROW_HEADER_MODE_ICON_ONLY);

		initializeContent(league);
		// this.setPageLength(2);

	}

	private void initializeContent(League league) {
		for (GamingTeam gamingTeam : league.getGamingTeamsStats().keySet()) {
			LeagueTeamStats teamStats = league.getGamingTeamsStats().get(
					gamingTeam);
			this.addItem(createStatsData(gamingTeam, teamStats),
					gamingTeam.getId());
		}

	}

	private Object[] createStatsData(GamingTeam gamingTeam,
			LeagueTeamStats teamStats) {
		return new Object[] { gamingTeam.getTeam().getName(),
				teamStats.getPoints(), teamStats.getNbGamesPlayed(),
				teamStats.getNbVictories(), teamStats.getNbTies(),
				teamStats.getNbDefeats(), teamStats.getGoalsScored(),
				teamStats.getGoalsTaken(), teamStats.getGoalAverage() };
	}
}

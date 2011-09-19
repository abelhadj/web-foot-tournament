package com.wft.service.services.tournament;

import java.util.Map.Entry;

import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.game.Game;
import com.wft.model.tournament.league.League;
import com.wft.model.tournament.league.LeagueTeamStats;

public class LeagueHelper {
	public static void syncTeamStatsFromGames(League league) {
		// clear all before the sync
		for (Entry<GamingTeam, LeagueTeamStats> stats : league.getGamingTeamsStats().entrySet()) {
			stats.getValue().clearStats();
		}

		for (Game game : league.getGamesPlayed()) {
			GamingTeam hostingTeam = game.getHostingTeam();
			GamingTeam visitorTeam = game.getVisitorTeam();

			LeagueTeamStats hostingTeamStats = getByGamingTeam(league,
					hostingTeam);
			LeagueTeamStats visitorTeamStats = getByGamingTeam(league,
					visitorTeam);

			updateHostingStats(league, hostingTeam, hostingTeamStats, game);
			updateVisitorStats(league, visitorTeam, visitorTeamStats, game);
		}

		// update goal average and points
		for (Entry<GamingTeam, LeagueTeamStats> stats : league.getGamingTeamsStats().entrySet()) {
			LeagueTeamStats statsValue = stats.getValue();
			statsValue.setGoalAverage(statsValue.getGoalsScored()-statsValue.getGoalsTaken());
			statsValue.setPoints(getPointsOfLeagueTeam(league, statsValue));
		}

	}

	private static LeagueTeamStats getByGamingTeam(League league,
			GamingTeam gamingTeam) {
		if (league.getGamingTeamsStats().containsKey(gamingTeam)) {
			return league.getGamingTeamsStats().get(gamingTeam);
		} else {
			LeagueTeamStats stats = new LeagueTeamStats();
			league.getGamingTeamsStats().put(gamingTeam, stats);
			return stats;
		}
	}

	private static void updateHostingStats(League league, GamingTeam team,
			LeagueTeamStats stats, Game game) {
		stats.setNbGamesPlayed(stats.getNbGamesPlayed() + 1);
		switch (game.getFinalScore().getType()) {
		case VICTORY:
			stats.setNbVictories(stats.getNbVictories() + 1);
		case DEFEAT:
			stats.setNbDefeats(stats.getNbDefeats() + 1);
		case TIE:
		default:
			stats.setNbTies(stats.getNbTies() + 1);
		}
		stats.setGoalsScored(stats.getGoalsScored()
				+ game.getFinalScore().getHostingScore());
		stats.setGoalsTaken(stats.getGoalsScored()
				+ game.getFinalScore().getVisitorScore());

	}

	private static void updateVisitorStats(League league, GamingTeam team,
			LeagueTeamStats stats, Game game) {
		stats.setNbGamesPlayed(stats.getNbGamesPlayed() + 1);
		switch (game.getFinalScore().getType()) {
		case VICTORY:
			stats.setNbDefeats(stats.getNbDefeats() + 1);
		case DEFEAT:
			stats.setNbVictories(stats.getNbVictories() + 1);
		case TIE:
		default:
			stats.setNbTies(stats.getNbTies() + 1);
		}
		stats.setGoalsScored(stats.getGoalsScored()
				+ game.getFinalScore().getVisitorScore());
		stats.setGoalsTaken(stats.getGoalsScored()
				+ game.getFinalScore().getHostingScore());

	}

	public static Integer getPointsOfLeagueTeam(League league,
			LeagueTeamStats stats) {
		return league.getPointsPerDefeat() * stats.getNbDefeats()
				+ league.getPointsPerTie() * stats.getNbTies()
				+ league.getPointsPerVictory() * stats.getNbVictories();
	}
}

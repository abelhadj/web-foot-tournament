package com.wft.service.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.team.Team;
import com.wft.model.team.TeamType;
import com.wft.model.tournament.GamingRequest;
import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.Tournament;
import com.wft.model.tournament.championship.Championship;
import com.wft.model.tournament.game.Game;
import com.wft.model.tournament.league.League;
import com.wft.model.tournament.league.LeagueTeamStats;
import com.wft.model.tournament.simplecup.CupNode;
import com.wft.model.tournament.simplecup.SimpleCup;
import com.wft.model.user.Organizer;
import com.wft.model.user.User;
import com.wft.service.core.impl.ServiceImpl;
import com.wft.service.dao.IGamingTeamDAO;
import com.wft.service.dao.ITeamDAO;
import com.wft.service.dao.ITournamentDAO;
import com.wft.service.services.ITeamRepositoryService;
import com.wft.service.services.ITournamentService;
import com.wft.service.services.tournament.LeagueHelper;
import com.wft.service.services.tournament.TournamentHelper;

@Service("tournamentService")
@Transactional(propagation = Propagation.REQUIRED)
public class TournamentService extends ServiceImpl<Tournament> implements
    ITournamentService {

  @Autowired
  private ITournamentDAO tournamentDAO;

  @Autowired
  private ITeamRepositoryService iTeamRepositoryService;

  @Autowired
  private ITeamDAO teamDAO;

  @Autowired
  private IGamingTeamDAO gamingTeamDAO;

  private static Log logger = LogFactory.getLog(TournamentService.class);

  private GamingTeam getNewUnassignedGamingTeam() {
    GamingTeam result = new GamingTeam();
    Team unassignedTeam = teamDAO.findByName(Team.UNASSIGNED_TEAM_NAME);
    if (unassignedTeam == null) {
      unassignedTeam = new Team(Team.UNASSIGNED_TEAM_NAME, TeamType.CLUB, "");
      teamDAO.add(unassignedTeam);
    }
    result.setTeam(unassignedTeam);
    gamingTeamDAO.add(result);
    return result;
  }

  public SimpleCup createSimpleCup(Organizer organizer, int nbTeams,
      String teamRepositoryName) {
    SimpleCup cup = new SimpleCup();
    initAbstractTournament(cup, organizer, teamRepositoryName);

    CupNode finalNode = new CupNode();
    cup.setFinalCupNode(finalNode);

    Vector<Integer> cupStructure = TournamentHelper
        .computeCupStructure(nbTeams);
    int depth = cupStructure.get(0);

    logger.info("Creating a cup with the structure : " + cupStructure);
    logger.info("teamRepositoryName : " + teamRepositoryName);

    createSubCupNode(finalNode, depth, cupStructure);

    tournamentDAO.add(cup);

    return cup;
  }

  private void initAbstractTournament(Tournament cup, Organizer organizer,
      String teamRepositoryName) {
    List<Organizer> organizers = new ArrayList<Organizer>();
    organizers.add(organizer);
    cup.setOrganizers(organizers);
    cup.setTeamRepoName(teamRepositoryName);
  }

  private void createSubCupNode(CupNode cupNode, int depth,
      Vector<Integer> cupStructure) {
    logger.info("createSubCupNode : depth=" + depth + " , cupStructure="
        + cupStructure);

    if (depth > 1 || (depth == 1 && cupStructure.get(1) > 0)) {
      CupNode hostingPreviouslyWonNode = new CupNode();
      cupNode.setHostingPreviouslyWonNode(hostingPreviouslyWonNode);
      createSubCupNode(hostingPreviouslyWonNode, depth - 1, cupStructure);

      CupNode visitorPreviouslyWonNode = new CupNode();
      cupNode.setVisitorPreviouslyWonNode(visitorPreviouslyWonNode);
      createSubCupNode(visitorPreviouslyWonNode, depth - 1, cupStructure);
    }

    Game game = new Game();
    game.setPlayed(false);

    if ((depth == 0 && cupStructure.get(1) > 0)
        || (depth == 1 && cupStructure.get(1) <= 0 && cupStructure.get(2) > 0)) {
      if (depth == 1 && cupStructure.get(1).equals(new Integer(0))) {
        cupStructure.set(1, -1);
      } else {
        game.setHostingTeam(getNewUnassignedGamingTeam());
        game.setPlayed(true);

        if (depth == 0) {
          cupStructure.set(1, cupStructure.get(1) - 1);
        }
        if (depth == 1) {
          cupStructure.set(2, cupStructure.get(2) - 1);
        }
      }
    }

    cupNode.setNodeGame(game);

  }

  public Championship createChampionship(Organizer organizer, int nbTeams,
      String teamRepositoryName) {
    Championship championship = new Championship();
    initAbstractTournament(championship, organizer, teamRepositoryName);
    championship.setLeague(new League());

    logger.info("Creating a championship with " + nbTeams + " teams.");
    logger.info("teamRepositoryName : " + teamRepositoryName);

    for (int i = 0; i < nbTeams; i++) {
      championship.getLeague().getGamingTeamsStats()
          .put(getNewUnassignedGamingTeam(), new LeagueTeamStats());
    }
    LeagueHelper.syncTeamStatsFromGames(championship.getLeague());

    tournamentDAO.add(championship);

    return championship;
  }

  public List<Tournament> getAllTournamentsAccessibleForUser(User user) {
    return tournamentDAO.findAll();
  }

  public void requestToPlayInTournament(Tournament tournament, Team team) {
    // TODO Auto-generated method stub

  }

  public List<GamingRequest> getAllPlayingRequests() {
    // TODO Auto-generated method stub
    return null;
  }

  public void acceptRequestToPlayInTournament(GamingRequest gamingRequest) {
    // TODO Auto-generated method stub

  }

  public Tournament retrieveTournamentById(Integer tournamentId) {
    return tournamentDAO.findById(tournamentId);
  }

  public Tournament autoAssignUnassignedTeams(Tournament tournament) {
    String teamRepoName = tournament.getTeamRepoName();
    List<Team> teams = new ArrayList<Team>(iTeamRepositoryService
        .getTeamRepositoryByName(teamRepoName).getAvailableTeams());

    if (tournament instanceof Championship) {
      Championship championship = (Championship) tournament;
      Iterator<GamingTeam> it = championship.getLeague().getGamingTeamsStats()
          .keySet().iterator();
      while (it.hasNext()) {
        GamingTeam gamingTeam = it.next();
        assignTeamFromList(gamingTeam, teams);
      }
    } else if (tournament instanceof SimpleCup) {
      SimpleCup simpleCup = (SimpleCup) tournament;
      CupNode cupNode = simpleCup.getFinalCupNode();

      autoAssignSimpleCup(cupNode, teams);
      normalizeCup(cupNode);

    }

    tournamentDAO.update(tournament);
    return tournament;
  }

  private void normalizeCup(CupNode cupNode) {
    CupNode hostingPreviouslyWonNode = cupNode.getHostingPreviouslyWonNode();
    CupNode visitorPreviouslyWonNode = cupNode.getVisitorPreviouslyWonNode();

    if (hostingPreviouslyWonNode.getNodeGame().isALeafGame()) {
      cupNode.getNodeGame().setHostingTeam(
          hostingPreviouslyWonNode.getNodeGame().getHostingTeam());
    } else {
      normalizeCup(hostingPreviouslyWonNode);
    }
    if (visitorPreviouslyWonNode.getNodeGame().isALeafGame()) {
      cupNode.getNodeGame().setVisitorTeam(
          visitorPreviouslyWonNode.getNodeGame().getHostingTeam());
    } else {
      normalizeCup(visitorPreviouslyWonNode);
    }

  }

  private void assignTeamFromList(GamingTeam gamingTeam, List<Team> teams) {
    if (!teams.contains(gamingTeam.getTeam())) {
      Team random = teams.get(new Random(System.currentTimeMillis())
          .nextInt(teams.size()));
      gamingTeam.setTeam(random);
      teams.remove(random);
    }
  }

  private void autoAssignSimpleCup(CupNode cupNode, List<Team> teams) {
    GamingTeam gamingTeam = cupNode.getNodeGame().getHostingTeam();
    if (gamingTeam != null) {
      if (Team.UNASSIGNED_TEAM_NAME.equals(gamingTeam.getTeam().getName())) {
        assignTeamFromList(gamingTeam, teams);
      }
    } else {
      autoAssignSimpleCup(cupNode.getHostingPreviouslyWonNode(), teams);
      autoAssignSimpleCup(cupNode.getVisitorPreviouslyWonNode(), teams);
    }
  }

}

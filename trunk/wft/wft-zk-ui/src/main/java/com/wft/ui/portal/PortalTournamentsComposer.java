package com.wft.ui.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.spring.context.annotation.EventHandler;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

import com.wft.model.tournament.championship.Championship;
import com.wft.model.tournament.simplecup.SimpleCup;
import com.wft.model.user.Organizer;
import com.wft.service.services.ITeamRepositoryService;
import com.wft.service.services.ITournamentService;
import com.wft.service.services.IUserService;
import com.wft.util.WFTEventUtil;
import com.wft.util.WFTUIHelper;

public class PortalTournamentsComposer extends GenericForwardComposer {

	@Autowired
	ITeamRepositoryService teamRepositoryService;

	@Autowired
	ITournamentService tournamentService;

	@Autowired
	IUserService userService;

	private Component thisComponent;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	}

  public void onCreateCupClick(int nbTeams, String teamRepositoryName) {
    Organizer organizer = (Organizer) userService.getCurrentlyConnected();
    SimpleCup cup = tournamentService.createSimpleCup(organizer, nbTeams,
        teamRepositoryName);
    tournamentService.autoAssignUnassignedTeams(cup);

    EventQueues
        .lookup(WFTEventUtil.WFT_APPLICATION, EventQueues.APPLICATION,
            true)
        .publish(
            new Event(
                WFTEventUtil.WFTPortalEvents.WFT_NEW_TOURNAMENT_TO_DISPLAY,
                null, cup.getId()));
  }

  public void onCreateChampionshipClick(int nbTeams, String teamRepositoryName) {
    Organizer organizer = (Organizer) userService.getCurrentlyConnected();
    Championship championship = tournamentService.createChampionship(organizer, nbTeams, teamRepositoryName);
    tournamentService.autoAssignUnassignedTeams(championship);

    EventQueues
        .lookup(WFTEventUtil.WFT_APPLICATION, EventQueues.APPLICATION,
            true)
        .publish(
            new Event(
                WFTEventUtil.WFTPortalEvents.WFT_NEW_TOURNAMENT_TO_DISPLAY,
                null, championship.getId()));
  }

}

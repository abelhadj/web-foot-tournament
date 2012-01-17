package com.wft.ui.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.zkoss.spring.util.GenericSpringComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zul.GroupsModelArray;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;

import com.wft.model.tournament.championship.Championship;
import com.wft.model.tournament.simplecup.SimpleCup;
import com.wft.model.user.Organizer;
import com.wft.service.services.ITeamRepositoryService;
import com.wft.service.services.ITournamentService;
import com.wft.service.services.IUserService;
import com.wft.util.WFTEventUtil;
import com.wft.util.WFTUIHelper;

@org.springframework.stereotype.Component("portalTournamentsComposer")
@Scope("desktop")
public class PortalTournamentsComposer extends GenericSpringComposer {

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
    this.thisComponent = comp;

    updateGamerView();

    final Component finalComp = comp;
    EventQueues.lookup(WFTEventUtil.WFT_APPLICATION, EventQueues.APPLICATION,
        true).subscribe(new EventListener() {
      public void onEvent(Event evt) {
        if (WFTEventUtil.WFTPortalEvents.WFT_TOURNAMENT_TO_DISPLAY.equals(evt
            .getName())) {
          updateGamerView();
        }
      }
    });

  }

  private void updateGamerView() {
    Listbox tournamentsList = (Listbox) WFTUIHelper.getChildByName(
        this.thisComponent, "tournamentsList");

    tournamentsList.setModel(new GroupsModelArray(
        tournamentService.getAllTournamentsAccessibleForUser(userService
            .getCurrentlyConnected()),
        new com.wft.ui.portal.TournamentListComparator()));
  }

  public void onCreateCupClick(int nbTeams, String teamRepositoryName) {
    Organizer organizer = (Organizer) userService.getCurrentlyConnected();
    SimpleCup cup = tournamentService.createSimpleCup(organizer, nbTeams,
        teamRepositoryName);
    tournamentService.autoAssignUnassignedTeams(cup);

    WFTUIHelper.publishEventToApplication(
        WFTEventUtil.WFTPortalEvents.WFT_TOURNAMENT_TO_DISPLAY, cup.getId());
  }

  public void onCreateChampionshipClick(int nbTeams, String teamRepositoryName) {
    Organizer organizer = (Organizer) userService.getCurrentlyConnected();
    Championship championship = tournamentService.createChampionship(organizer,
        nbTeams, teamRepositoryName);
    tournamentService.autoAssignUnassignedTeams(championship);

    WFTUIHelper.publishEventToApplication(
        WFTEventUtil.WFTPortalEvents.WFT_TOURNAMENT_TO_DISPLAY, championship.getId());
  }

}

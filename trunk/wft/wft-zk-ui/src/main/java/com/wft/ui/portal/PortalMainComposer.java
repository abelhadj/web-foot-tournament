package com.wft.ui.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.zkoss.spring.util.GenericSpringComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.EventQueues;

import com.wft.model.tournament.Tournament;
import com.wft.service.services.ITeamRepositoryService;
import com.wft.service.services.ITournamentService;
import com.wft.service.services.IUserService;
import com.wft.ui.tournament.TournamentPanel;
import com.wft.util.WFTEventUtil;

@org.springframework.stereotype.Component("portalMainComposer")
@Scope("desktop")
public class PortalMainComposer extends GenericSpringComposer  {

	@Autowired
	ITeamRepositoryService teamRepositoryService;

	@Autowired
	ITournamentService tournamentService;

	@Autowired
	IUserService userService;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		final Component finalComp = comp;
		EventQueues.lookup(WFTEventUtil.WFT_APPLICATION, EventQueues.APPLICATION, true).subscribe(
				  new EventListener<Event>() {
				    public void onEvent(Event evt) {
				    	if (WFTEventUtil.WFTPortalEvents.WFT_TOURNAMENT_TO_DISPLAY.equals(evt.getName())) {
				    	  if (finalComp.getFirstChild() != null) {
	                finalComp.removeChild(finalComp.getFirstChild());
				    	  }
				    		Integer tournamentId = (Integer) evt.getData();
				    		Tournament tournament = tournamentService.retrieveTournamentById(tournamentId);
				    		
				    		finalComp.appendChild(new TournamentPanel(tournament));
				    	}
				    }
				  });

	}


}

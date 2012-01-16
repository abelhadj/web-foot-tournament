package com.wft.ui.tournament;

import org.springframework.context.annotation.Scope;
import org.zkoss.spring.util.GenericSpringComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;

import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.game.Game;
import com.wft.util.WFTUIHelper;

@org.springframework.stereotype.Component("gameComposer")
@Scope("desktop")
public class GameComposer extends GenericSpringComposer {

	private Game game;

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		Label htNameLbl = (Label) WFTUIHelper.getChildByName(comp,
				"hostingTeamName");
		Label htDetailsLbl = (Label) WFTUIHelper.getChildByName(comp,
		"hostingTeamDetails");
		GamingTeam hGTeam = game.getHostingTeam();
		synchronizeGamingTeamToLabel(htNameLbl, hGTeam);
		synchronizeGamingTeamToLabel(htDetailsLbl, hGTeam, "Details about : ");

		Label vtNameLbl = (Label) WFTUIHelper.getChildByName(comp,
				"visitorTeamName");
		Label vtDetailsLbl = (Label) WFTUIHelper.getChildByName(comp,
		"visitorTeamDetails");
		GamingTeam vGTeam = game.getVisitorTeam();
		synchronizeGamingTeamToLabel(vtNameLbl, vGTeam);
		synchronizeGamingTeamToLabel(vtDetailsLbl, vGTeam, "Details about : ");

		if (game.isALeafGame()) {
			Grid grid = (Grid) WFTUIHelper.getChildByName(comp, "gameGrid");

			grid.getRows().removeChild(grid.getRows().getLastChild());

			htNameLbl.setStyle("color:green");
		}
	}

	private void synchronizeGamingTeamToLabel(Label label, GamingTeam gTeam) {
		synchronizeGamingTeamToLabel(label, gTeam, "");
	}

	private void synchronizeGamingTeamToLabel(Label label, GamingTeam gTeam,
			String prefix) {
		if (gTeam != null && gTeam.getTeam() != null) {
			label.setValue(prefix + gTeam.getTeam().getName());
		}
	}

}

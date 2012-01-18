package com.wft.ui.tournament;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;

import com.wft.model.tournament.championship.Championship;
import com.wft.model.tournament.league.League;

public class ChampionshipUI extends Panel {

	public ChampionshipUI(Championship championship) {
		super();

		Panelchildren panelchildren = new Panelchildren();
		panelchildren.setStyle("overflow:auto;");

		Map<String,League> args = new HashMap<String, League>();
		args.put("league", championship.getLeague());

		// TODO UI from nodeGame
		Component game = Executions.createComponents(
				"/app/tournament/league.zul", panelchildren, args);

		panelchildren.appendChild(game);
		this.appendChild(panelchildren);

	}


}

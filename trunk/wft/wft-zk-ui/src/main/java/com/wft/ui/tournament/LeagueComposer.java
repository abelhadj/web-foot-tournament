package com.wft.ui.tournament;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.zkoss.spring.util.GenericSpringComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;

import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.game.Game;
import com.wft.model.tournament.league.League;
import com.wft.util.WFTUIHelper;

@org.springframework.stereotype.Component("leagueComposer")
@Scope("desktop")
public class LeagueComposer extends GenericSpringComposer {

  private League league;

  public void setGame(League league) {
    this.league = league;
  }

  @Override
  public void doAfterCompose(Component comp) throws Exception {
    super.doAfterCompose(comp);

  }


}

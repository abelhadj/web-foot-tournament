package com.wft.ui.tournament;

import org.springframework.context.annotation.Scope;
import org.zkoss.spring.util.GenericSpringComposer;
import org.zkoss.zk.ui.Component;

import com.wft.model.tournament.league.League;

@org.springframework.stereotype.Component("leagueComposer")
@Scope("desktop")
public class LeagueComposer extends GenericSpringComposer {

  private League league;

  public void setLeague(League league) {
    this.league = league;
  }

  @Override
  public void doAfterCompose(Component comp) throws Exception {
    super.doAfterCompose(comp);

  }


}

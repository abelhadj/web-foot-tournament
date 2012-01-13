package com.wft.ui.portal;


import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listgroup;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.wft.model.tournament.Tournament;

public class TournamentsListItemRenderer implements ListitemRenderer {

  public void render(Listitem listitem, Object obj) throws Exception {
    if (listitem instanceof Listgroup) {
      Tournament tournament = (Tournament) obj;
      listitem.appendChild(new Listcell(tournament.getCategory()));
    } else {
      Tournament data = (Tournament) obj;
      listitem.appendChild(new Listcell(data.getCategory()));
      listitem.appendChild(new Listcell(data.getTeamRepoName()));
    }
  }
}

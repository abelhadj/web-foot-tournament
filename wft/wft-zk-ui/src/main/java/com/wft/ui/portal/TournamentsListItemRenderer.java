package com.wft.ui.portal;

import org.apache.commons.lang.StringUtils;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listgroup;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import com.wft.model.tournament.Tournament;
import com.wft.model.user.Organizer;
import com.wft.util.WFTEventUtil;
import com.wft.util.WFTUIHelper;

public class TournamentsListItemRenderer implements ListitemRenderer {

  public void render(final Listitem listitem, Object obj) throws Exception {
    listitem.setCheckable(false);
    if (listitem instanceof Listgroup) {
      final Tournament tournament = (Tournament) obj;
      listitem.appendChild(new Listcell(Labels.getLabel(tournament
          .getCategory())));
    } else {
      final Tournament tournament = (Tournament) obj;
      listitem.appendChild(new Listcell(getOrganizerLogins(tournament)));
      listitem.appendChild(new Listcell(tournament.getTeamRepoName()));
      listitem.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
        public void onEvent(Event event) throws Exception {
          WFTUIHelper.publishEventToApplication(
              WFTEventUtil.WFTPortalEvents.WFT_TOURNAMENT_TO_DISPLAY,
              tournament.getId());
        }
      });
      listitem.addEventListener(Events.ON_MOUSE_OVER, new EventListener<Event>() {
        public void onEvent(Event event) throws Exception {
          listitem.setTooltiptext("Tooltip :<br/>\nhello !");
        }
      });
    }
  }

  private String getOrganizerLogins(Tournament tournament) {
    String result = "";
    for (Organizer org : tournament.getOrganizers()) {
      result += org.getLogin() + " ";
    }
    return result;
  }
}

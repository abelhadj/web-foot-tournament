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
    Image htImage = (Image) WFTUIHelper
        .getChildByName(comp, "hostingTeamImage");
    Label htDetailsLbl = (Label) WFTUIHelper.getChildByName(comp,
        "hostingTeamDetails");
    GamingTeam hGTeam = game.getHostingTeam();
    synchronizeGamingTeamToLabel(htNameLbl, hGTeam);
    synchronizeGamingTeamToImage(htImage, hGTeam);
    synchronizeGamingTeamToLabel(htDetailsLbl, hGTeam, "Details about : ");

    Label vtNameLbl = (Label) WFTUIHelper.getChildByName(comp,
        "visitorTeamName");
    Image vtImage = (Image) WFTUIHelper
        .getChildByName(comp, "visitorTeamImage");
    Label vtDetailsLbl = (Label) WFTUIHelper.getChildByName(comp,
        "visitorTeamDetails");
    GamingTeam vGTeam = game.getVisitorTeam();
    synchronizeGamingTeamToLabel(vtNameLbl, vGTeam);
    synchronizeGamingTeamToImage(vtImage, vGTeam);
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

  private void synchronizeGamingTeamToImage(Image image, GamingTeam gTeam) {
    if (gTeam != null && gTeam.getTeam() != null) {
      if (StringUtils.isNotEmpty(gTeam.getTeam().getImagePath())) {
        image.setSrc(gTeam.getTeam().getImagePath());
      }
    }
  }

}

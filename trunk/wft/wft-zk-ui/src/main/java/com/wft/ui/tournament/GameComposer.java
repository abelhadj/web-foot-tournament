package com.wft.ui.tournament;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.zkoss.spring.util.GenericSpringComposer;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Button;
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

    synchronizeGamingTeamToUI(comp, game.getHostingTeam(), "hosting");
    synchronizeGamingTeamToUI(comp, game.getVisitorTeam(), "visitor");

    if (game.isALeafGame()) {
      Grid grid = (Grid) WFTUIHelper.getChildByName(comp, "gameGrid");

      grid.getRows().removeChild(grid.getRows().getLastChild());

      Label htNameLbl = (Label) WFTUIHelper.getChildByName(comp,
          "hostingTeamName");
      htNameLbl.setStyle("color:green");
    }
  }

  private void synchronizeGamingTeamToUI(Component comp, GamingTeam gTeam,
      String idsPrefix) {
    if (gTeam != null) {
      Image gtImage = (Image) WFTUIHelper.getChildByName(comp, idsPrefix
          + "TeamImage");
      Label gtNameLbl = (Label) WFTUIHelper.getChildByName(comp, idsPrefix
          + "TeamName");
      Button gtGamerBtn = (Button) WFTUIHelper.getChildByName(comp, idsPrefix
          + "Gamer");
      Label gtDetailsLbl = (Label) WFTUIHelper.getChildByName(comp, idsPrefix
          + "TeamDetails");
      synchronizeGamingTeamToImage(gtImage, gTeam);
      synchronizeGamingTeamToLabel(gtNameLbl, gTeam);
      synchronizeGamingTeamToGamerButton(gtGamerBtn, gTeam);
      synchronizeGamingTeamToLabel(gtDetailsLbl, gTeam, "Details about : ");
    }
  }

  private void synchronizeGamingTeamToGamerButton(Button htGamerBtn,
      GamingTeam gTeam) {
    if (gTeam.getGamer() == null) {
      htGamerBtn.setLabel("Unassigned");
      htGamerBtn.setStyle("color:green");
    } else {
      htGamerBtn.setLabel(gTeam.getGamer().getLogin());
    }
  }

  private void synchronizeGamingTeamToLabel(Label label, GamingTeam gTeam) {
    synchronizeGamingTeamToLabel(label, gTeam, "");
  }

  private void synchronizeGamingTeamToLabel(Label label, GamingTeam gTeam,
      String prefix) {
    if (gTeam.getTeam() != null) {
      label.setValue(prefix + gTeam.getTeam().getName());
    }
  }

  private void synchronizeGamingTeamToImage(Image image, GamingTeam gTeam) {
    if (gTeam.getTeam() != null) {
      if (StringUtils.isNotEmpty(gTeam.getTeam().getImagePath())) {
        image.setSrc(gTeam.getTeam().getImagePath());
      }
    }
  }

}

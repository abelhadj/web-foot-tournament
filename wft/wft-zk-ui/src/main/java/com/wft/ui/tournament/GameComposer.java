package com.wft.ui.tournament;

import org.zkoss.image.Image;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;

import com.wft.model.tournament.GamingTeam;
import com.wft.model.tournament.game.Game;
import com.wft.util.WFTUIHelper;

public class GameComposer extends GenericForwardComposer {

  private Game game;

  public void setGame(Game game) {
    this.game = game;
  }

  @Override
  public void doAfterCompose(Component comp) throws Exception {
    super.doAfterCompose(comp);

    Component htComp = WFTUIHelper.getChildByName(comp, "hostingTeam");
    GamingTeam hGTeam = game.getHostingTeam();
    synchronizeGamingTeamToButtonLabel(htComp, hGTeam);
    
    Component vtComp = WFTUIHelper.getChildByName(comp, "visitorTeam");
    GamingTeam vGTeam = game.getVisitorTeam();
    synchronizeGamingTeamToButtonLabel(vtComp, vGTeam);

    if (game.isALeafGame()) {
      Component vP = WFTUIHelper.getChildByName(comp, "visitorPanel");
      Component vsP = WFTUIHelper.getChildByName(comp, "visitorScorePanel");

      vP.getParent().removeChild(vP);
      vsP.getParent().removeChild(vsP);
      
      highlightWinningGamingTeam(htComp);
    }
  }

  private void synchronizeGamingTeamToButtonLabel(Component vtComp,
      GamingTeam gTeam) {
    if (vtComp instanceof Button) {
      Button vtButton = (Button) vtComp;
      if (gTeam != null && gTeam.getTeam() != null) {
        vtButton.setLabel(gTeam.getTeam().getName());
      }
    }
  }

  private void highlightWinningGamingTeam(Component comp) {
    Button button = (Button) comp;
    button.setStyle("color:green");
  }
  

}

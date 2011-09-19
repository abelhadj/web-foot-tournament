package com.wft.ui.tournament;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import com.wft.model.tournament.game.Game;
import com.wft.model.tournament.simplecup.CupNode;
import com.wft.model.tournament.simplecup.SimpleCup;
import com.wft.service.services.ITournamentService;
import com.wft.ui.tournament.game.WGame;
import com.wft.util.WFTUIHelper;

public class WSimpleCup extends Panel {

	private SimpleCup simpleCup;

	private static Log logger = LogFactory.getLog(WSimpleCup.class);

	private transient ITournamentService iTournamentService = WFTUIHelper
			.getApplicationServiceProvider().getTournamentService();

	public WSimpleCup(SimpleCup simpleCup) {
		super();
		this.simpleCup = simpleCup;
		initializeContent(simpleCup);
		this.setScrollable(true);
		this.setHeight(75, Sizeable.UNITS_PERCENTAGE);
		this.setWidth(100, Sizeable.UNITS_PERCENTAGE);
	}

	private void initializeContent(final SimpleCup simpleCup) {

		VerticalLayout vLay = new VerticalLayout();

		Button b = new Button("Auto assign");
		vLay.addComponent(b);

		final WSimpleCup finalThis = this;
		b.addListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				WSimpleCup.this.simpleCup = (SimpleCup) iTournamentService.autoAssignUnassignedTeams(simpleCup);
				finalThis.initializeContent(WSimpleCup.this.simpleCup);
			}
		});

		int depth = analyseCupNodeDepth(simpleCup.getFinalCupNode());
		logger.info("Analyzed depth : " + depth);

		GridLayout lay = new GridLayout(depth, (int) (Math.pow(2, depth) - 1));
		fillGrid(lay, depth, (int) (Math.pow(2, depth) - 1));

		CupNode finalCupNode = simpleCup.getFinalCupNode();
		updateGridLayoutWithCupNode(lay, finalCupNode, depth, 0);

		lay.setSizeFull();

		vLay.addComponent(lay);

		vLay.setSizeFull();

		this.setContent(vLay);
	}

	private void fillGrid(GridLayout lay, int columns, int rows) {
		for (int row = 0; row < rows; row++) {
			lay.setRowExpandRatio(row, 1.0f);
		}
		for (int col = 0; col < columns; col++) {
			lay.setColumnExpandRatio(col, 1.0f);
		}
		WGame wgame = new WGame(null);
		for (int col = 0; col < columns; col++) {
			for (int row = 0; row < rows; row++) {
				Panel panel = new Panel();
				panel.setStyleName(Reindeer.PANEL_LIGHT);
				panel.setHeight(wgame.getHeight(), wgame.getHeightUnits());
				panel.setWidth(wgame.getWidth(), wgame.getWidthUnits());
				lay.addComponent(panel, col, row);
			}
		}
	}

	private int analyseCupNodeDepth(CupNode cupNode) {
		int localDepth = 0;
		int firstDepth = 0, secondDepth = 0, maxDepth = 0;
		if (cupNode.getHostingPreviouslyWonNode() != null) {
			firstDepth = analyseCupNodeDepth(cupNode
					.getHostingPreviouslyWonNode());
		}
		if (cupNode.getVisitorPreviouslyWonNode() != null) {
			secondDepth = analyseCupNodeDepth(cupNode
					.getVisitorPreviouslyWonNode());
		}
		if (firstDepth > secondDepth) {
			localDepth = firstDepth + 1;
		} else {
			localDepth = secondDepth + 1;
		}

		return localDepth;
	}

	private void updateGridLayoutWithCupNode(GridLayout lay, CupNode cupNode,
			int depth, int columnOffset) {

		logger.info("updateGridLayoutWithCupNode : depth=" + depth
				+ " , columnOffset=" + columnOffset);

		Game game = cupNode.getNodeGame();
		if (game != null) {
			WGame wGame = new WGame(game);
			logger.info("lay.addComponent [depth=" + depth + ",offset="
					+ columnOffset + "] : " + wGame + ", x=" + (depth - 1)
					+ ", y="
					+ (int) (Math.pow(2, depth - 1) - 1 + columnOffset));
			if (lay.getComponent(depth - 1,
					(int) (Math.pow(2, depth - 1) - 1 + columnOffset)) != null) {
				lay.removeComponent(depth - 1,
						(int) (Math.pow(2, depth - 1) - 1 + columnOffset));
			}
			lay.addComponent(wGame, depth - 1,
					(int) (Math.pow(2, depth - 1) - 1 + columnOffset));
		}

		if (cupNode.getHostingPreviouslyWonNode() != null) {
			updateGridLayoutWithCupNode(lay,
					cupNode.getHostingPreviouslyWonNode(), depth - 1,
					columnOffset);
		}
		if (cupNode.getVisitorPreviouslyWonNode() != null) {
			updateGridLayoutWithCupNode(lay,
					cupNode.getVisitorPreviouslyWonNode(), depth - 1,
					columnOffset + (int) Math.pow(2, depth - 1));
		}
	}

}

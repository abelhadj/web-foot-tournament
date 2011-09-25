package com.wft.ui.tournament;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zkmax.zul.Tablechildren;
import org.zkoss.zkmax.zul.Tablelayout;
import org.zkoss.zul.Label;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Panelchildren;

import com.wft.model.tournament.game.Game;
import com.wft.model.tournament.simplecup.CupNode;
import com.wft.model.tournament.simplecup.SimpleCup;

public class SimpleCupUI extends Tablelayout {

	private Vector<Tablechildren> tablechildrenOfColumns;
	private String eltHeight;

	public SimpleCupUI(SimpleCup simpleCup) {
		super();

		CupNode cupNode = simpleCup.getFinalCupNode();
		int depth = analyseCupNodeDepth(cupNode);

		this.initTableLayout(depth + 1);

		generateCupNodeUI(cupNode, depth, true);

	}

	private void initTableLayout(int nbColumns) {
		this.tablechildrenOfColumns = new Vector<Tablechildren>(nbColumns);
		this.setColumns(nbColumns);
	}

	private void generateCupNodeUI(CupNode cupNode, int depth, boolean init) {
		if (cupNode.getHostingPreviouslyWonNode() != null) {
			generateCupNodeUI(cupNode.getHostingPreviouslyWonNode(), depth - 1,
					init);
		}
		if (cupNode.getVisitorPreviouslyWonNode() != null) {
			generateCupNodeUI(cupNode.getVisitorPreviouslyWonNode(), depth - 1,
					false);
		}

		// 1
		if (init) {
			Tablechildren newTablechildren = getANewTableChildren();
			tablechildrenOfColumns.add(depth, newTablechildren);

			int nbBlanks = (int) Math.pow(2, depth) - 1;
			appendBlanksUI(newTablechildren, nbBlanks);
		}

		Tablechildren tableChildren = tablechildrenOfColumns.get(depth);

		// 2
		appendNodeGameUI(tableChildren, cupNode.getNodeGame());

		// 3
		int nbBlanks = (int) Math.pow(2, depth + 1) - 1;
		appendBlanksUI(tableChildren, nbBlanks);

	}

	private void appendNodeGameUI(Tablechildren tableChildren, Game nodeGame) {
		Panel panel = new Panel();
		Panelchildren panelchildren = new Panelchildren();

		// TODO UI from nodeGame
		Component game = Executions.createComponents(
				"/app/tournament/game.zul", panelchildren, null);

		panelchildren.appendChild(game);
		panel.appendChild(panelchildren);
		if (this.eltHeight == null) {
			this.eltHeight = panel.getHeight();
			System.out.println(this.eltHeight);
		}
		tableChildren.appendChild(panel);
	}

	private void appendBlanksUI(Tablechildren tableChildren, int nbBlanks) {
		while (nbBlanks > 0) {
			Panel panel = new Panel();
			Panelchildren panelchildren = new Panelchildren();
			Component game = Executions.createComponents(
					"/app/tournament/blank.zul", panelchildren, null);
			panel.appendChild(panelchildren);
			tableChildren.appendChild(panel);

			nbBlanks--;
		}

	}

	private Tablechildren getANewTableChildren() {
		Tablechildren tablechildren = new Tablechildren();
		this.appendChild(tablechildren);
		return tablechildren;
	}

	private int analyseCupNodeDepth(CupNode cupNode) {
		int localDepth = -1;
		int firstDepth = -1, secondDepth = -1;
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

}

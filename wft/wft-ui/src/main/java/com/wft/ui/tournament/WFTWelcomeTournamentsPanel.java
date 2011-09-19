package com.wft.ui.tournament;

import java.net.URISyntaxException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.vaadin.data.collectioncontainer.CollectionContainer;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.wft.model.tournament.championship.Championship;
import com.wft.model.tournament.simplecup.SimpleCup;
import com.wft.model.user.Organizer;
import com.wft.model.user.User;
import com.wft.service.services.ITeamRepositoryService;
import com.wft.service.services.ITournamentService;
import com.wft.service.services.IUserService;
import com.wft.util.ApplicationHelper;
import com.wft.util.WFTUIHelper;

@Component(value = "wftWelcomeTournamentsPanel")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WFTWelcomeTournamentsPanel extends Panel implements
		InitializingBean {

	@Autowired
	private transient ITournamentService iTournamentService;

	@Autowired
	private transient ITeamRepositoryService iTeamRepositoryService;

	@Autowired
	private transient IUserService iUserService;

	public void afterPropertiesSet() throws Exception {
		initializeContent();
	}

	private void initializeContent() {
		VerticalLayout lay = new VerticalLayout();
		User user = iUserService.getCurrentlyConnected();
		// System.out.println("User connected is instance of : "+user.getClass().getName());
		if (user instanceof Organizer) {
			final Organizer organizer = (Organizer)user;
			Button createCupButton = getCreateCupButton();
			lay.addComponent(createCupButton);

			Button createChampionshipButton = getCreateChampionshipButton();
			lay.addComponent(createChampionshipButton);

			final TextField tf = new TextField("nb équipes", "13");
			lay.addComponent(tf);
			
			final ComboBox teamRepoCb = new ComboBox("avec les équipes de");
			CollectionContainer data = new CollectionContainer(iTeamRepositoryService.getAllRepositoriesName(), true,CollectionContainer.ITEM_ID_MODE_OBJECT);
			teamRepoCb.setContainerDataSource(data);
			teamRepoCb.select(data.firstItemId());
			
			lay.addComponent(teamRepoCb);
			
			createCupButton.addListener(new ClickListener() {

				public void buttonClick(ClickEvent event) {
					SimpleCup cup = iTournamentService.createSimpleCup(
							organizer,
							Integer.parseInt((String) tf.getValue()), (String) teamRepoCb.getValue());
					WFTUIHelper.getWelcomeMainPanel().displayTournament(cup);
				}
			});
			createChampionshipButton.addListener(new ClickListener() {

				public void buttonClick(ClickEvent event) {
					Championship championship = iTournamentService.createChampionship(
							organizer,
							Integer.parseInt((String) tf.getValue()), (String) teamRepoCb.getValue());
					WFTUIHelper.getWelcomeMainPanel().displayTournament(championship);
				}
			});
			setContent(lay);
		} else {
			addComponent(new Label("Vous n'êtes pas organisateur"));
			Button b = new Button("Demander à être organisateur");
			addComponent(b);
		}

	}

	public WFTWelcomeTournamentsPanel() {
		super("Tournois");
		setSizeFull();
	}
	
	private Button getCreateCupButton() {
		Button b = new Button("Créer une coupe !");
		b.setHeight(35,Sizeable.UNITS_PIXELS);
		try {
			b.setIcon(ApplicationHelper.getFileResource("/img/trophy.png"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	private Button getCreateChampionshipButton() {
		Button b = new Button("Créer un championnat !");
		b.setHeight(35,Sizeable.UNITS_PIXELS);
		try {
			b.setIcon(ApplicationHelper.getFileResource("/img/trophy.png"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}

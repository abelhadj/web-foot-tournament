package com.wft.ui.welcome.tournaments;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

@Component(value = "wftWelcomeTournamentsPanel")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WFTWelcomeTournamentsPanel extends Panel {

	public WFTWelcomeTournamentsPanel() {
		super("Tournaments");
		setSizeFull();
	}

}

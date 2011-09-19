package com.wft.ui.welcome.calendar;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

@Component(value = "wftWelcomeCalendarPanel")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WFTWelcomeCalendarPanel extends Panel {

	public WFTWelcomeCalendarPanel() {
		super("Calendrier");
		setSizeFull();
	}

}

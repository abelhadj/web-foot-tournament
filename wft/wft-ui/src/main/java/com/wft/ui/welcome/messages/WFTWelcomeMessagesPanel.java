package com.wft.ui.welcome.messages;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

@Component(value = "wftWelcomeMessagesPanel")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WFTWelcomeMessagesPanel extends Panel {

	public WFTWelcomeMessagesPanel() {
		super("Messages");
		setSizeFull();
	}

}

package com.wft.ui.welcome.chat;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

@Component(value = "wftWelcomeChatPanel")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WFTWelcomeChatPanel extends Panel {

	public WFTWelcomeChatPanel() {
		super("Chat");
		setSizeFull();
	}

}

/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.wft.ui.welcome;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.wft.service.services.AuthenticationService;
import com.wft.ui.welcome.calendar.WFTWelcomeCalendarPanel;
import com.wft.ui.welcome.chat.WFTWelcomeChatPanel;
import com.wft.ui.welcome.messages.WFTWelcomeMessagesPanel;
import com.wft.ui.welcome.profile.WFTWelcomeProfilePanel;
import com.wft.ui.welcome.tournaments.WFTWelcomeTournamentsPanel;

/**
 * The Application's "main" class
 */
@Component(value = "wftWelcomeWindow")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WFTWelcomeWindow extends Window implements InitializingBean {

	@Autowired
	private transient WFTWelcomeCalendarPanel wftWelcomeCalendarWindow;

	@Autowired
	private transient WFTWelcomeChatPanel wftWelcomeChatWindow;

	@Autowired
	private transient WFTWelcomeMessagesPanel wftWelcomeMessagesWindow;

	@Autowired
	private transient WFTWelcomeProfilePanel wftWelcomeProfileWindow;

	@Autowired
	private transient WFTWelcomeTournamentsPanel wftWelcomeTournamentsWindow;

	public WFTWelcomeWindow() {
		super("Web Foot Tournament");
		setSizeFull();
	}

	public void afterPropertiesSet() throws Exception {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeFull();
		setContent(layout);

		VerticalLayout leftLayout = new VerticalLayout();
		leftLayout.setSizeFull();
		layout.addComponent(leftLayout);
		layout.setExpandRatio(leftLayout, 1);

		VerticalLayout middleLayout = new VerticalLayout();
		middleLayout.setSizeFull();
		layout.addComponent(middleLayout);
		layout.setExpandRatio(middleLayout, 3);
		
		VerticalLayout rightLayout = new VerticalLayout();
		rightLayout.setSizeFull();
		layout.addComponent(rightLayout);
		layout.setExpandRatio(rightLayout, 1);

		
		leftLayout.addComponent(wftWelcomeProfileWindow);
		leftLayout.setExpandRatio(wftWelcomeProfileWindow, 1);
		
		leftLayout.addComponent(wftWelcomeTournamentsWindow);
		leftLayout.setExpandRatio(wftWelcomeTournamentsWindow, 1);
		
		leftLayout.addComponent(wftWelcomeCalendarWindow);
		leftLayout.setExpandRatio(wftWelcomeCalendarWindow, 1);

		Panel midPanel = new Panel("Middle view");
		midPanel.setSizeFull();
		middleLayout.addComponent(midPanel);

		rightLayout.addComponent(wftWelcomeMessagesWindow);
		rightLayout.setExpandRatio(wftWelcomeMessagesWindow, 1);

		rightLayout.addComponent(wftWelcomeChatWindow);
		rightLayout.setExpandRatio(wftWelcomeChatWindow, 1);
		
		setImmediate(true);
	}

}

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

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wft.ui.tournament.WFTWelcomeTournamentsPanel;
import com.wft.ui.welcome.calendar.WFTWelcomeCalendarPanel;
import com.wft.ui.welcome.chat.WFTWelcomeChatPanel;
import com.wft.ui.welcome.messages.WFTWelcomeMessagesPanel;
import com.wft.ui.welcome.profile.WFTWelcomeProfilePanel;

/**
 * The Application's "main" class
 */
@Component(value = "wftWelcomeWindow")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WFTWelcomeWindow extends Window implements InitializingBean {

	@Autowired
	private transient WFTWelcomeCalendarPanel wftWelcomeCalendarPanel;

	@Autowired
	private transient WFTWelcomeChatPanel wftWelcomeChatPanel;

	@Autowired
	private transient WFTWelcomeMessagesPanel wftWelcomeMessagesPanel;

	@Autowired
	private transient WFTWelcomeProfilePanel wftWelcomeProfilePanel;

	@Autowired
	private transient WFTWelcomeTournamentsPanel wftWelcomeTournamentsPanel;

	@Autowired
	private transient WFTWelcomeMainPanel wftWelcomeMainPanel;

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

		
		leftLayout.addComponent(wftWelcomeProfilePanel);
		leftLayout.setExpandRatio(wftWelcomeProfilePanel, 1);
		
		leftLayout.addComponent(wftWelcomeTournamentsPanel);
		leftLayout.setExpandRatio(wftWelcomeTournamentsPanel, 1);
		
		leftLayout.addComponent(wftWelcomeCalendarPanel);
		leftLayout.setExpandRatio(wftWelcomeCalendarPanel, 1);

		middleLayout.addComponent(wftWelcomeMainPanel);

		rightLayout.addComponent(wftWelcomeMessagesPanel);
		rightLayout.setExpandRatio(wftWelcomeMessagesPanel, 1);

		rightLayout.addComponent(wftWelcomeChatPanel);
		rightLayout.setExpandRatio(wftWelcomeChatPanel, 1);
		
		setImmediate(true);
	}

	public WFTWelcomeCalendarPanel getWftWelcomeCalendarPanel() {
		return wftWelcomeCalendarPanel;
	}

	public WFTWelcomeChatPanel getWftWelcomeChatPanel() {
		return wftWelcomeChatPanel;
	}

	public WFTWelcomeMessagesPanel getWftWelcomeMessagesPanel() {
		return wftWelcomeMessagesPanel;
	}

	public WFTWelcomeProfilePanel getWftWelcomeProfilePanel() {
		return wftWelcomeProfilePanel;
	}

	public WFTWelcomeTournamentsPanel getWftWelcomeTournamentsPanel() {
		return wftWelcomeTournamentsPanel;
	}

	public WFTWelcomeMainPanel getWftWelcomeMainPanel() {
		return wftWelcomeMainPanel;
	}
	
	

}

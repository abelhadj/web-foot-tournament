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
package com.wft.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.terminal.gwt.client.ui.AlignmentInfo.Bits;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wft.service.services.ITournamentService;
import com.wft.service.services.IUserService;
import com.wft.ui.forms.user.CreateUserForm;
import com.wft.ui.login.WFTLoginForm;
import com.wft.util.BaseApplication;

/**
 * The Application's "main" class
 */
@Component(value = "welcomeLoginApplication")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WelcomeLoginApplication extends BaseApplication implements ApplicationServiceProvider {
	private Window window;

	@Autowired
	private transient WFTLoginForm wftLoginForm;

	private VerticalLayout verticalLayout;

	private Window subwindow;
	
	@Autowired
	private transient IUserService iUserService;

	@Autowired
	private transient ITournamentService iTournamentService;

	public IUserService getUserService() {
		return iUserService;
	}

	public ITournamentService getTournamentService() {
		return iTournamentService;
	}
	
	@Override
	public void init() {
		window = new Window("Web Foot Tournament");

        subwindow = new Window("Connexion");
        // ...and make it modal
        subwindow.setModal(true);
        subwindow.setClosable(false);
        subwindow.setResizable(false);
        subwindow.setWidth("50%");
        subwindow.setHeight("50%");

        // Configure the windows layout; by default a VerticalLayout
        verticalLayout = new VerticalLayout();
        subwindow.setContent(verticalLayout);
        verticalLayout.setMargin(true);
        verticalLayout.setSpacing(true);
        verticalLayout.setSizeFull();

        
		wftLoginForm.setSizeFull();
		verticalLayout.addComponent(wftLoginForm);
		verticalLayout.setComponentAlignment(wftLoginForm, new Alignment(Bits.ALIGNMENT_HORIZONTAL_CENTER|Bits.ALIGNMENT_VERTICAL_CENTER));

        Button createUserBtn = new Button();
        createUserBtn.setCaption("Not yet an user ? Create an account !");
        createUserBtn.addListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				switchToCreateUserForm();
			}
		});
        verticalLayout.addComponent(createUserBtn);
                
        window.addWindow(subwindow);

		setMainWindow(window);

	}
	
	private void switchToCreateUserForm() {
		verticalLayout.removeAllComponents();
		CreateUserForm createUserForm = new CreateUserForm();
		createUserForm.setSizeFull();
		verticalLayout.addComponent(createUserForm);
		
	}



}

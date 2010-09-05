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
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wft.service.services.AuthenticationService;
import com.wft.ui.login.WFTLoginForm;
import com.wft.util.BaseApplication;

/**
 * The Application's "main" class
 */
@Component(value = "welcomeLoginApplication")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WelcomeLoginApplication extends BaseApplication {
	private Window window;

	@Autowired
	private transient WFTLoginForm wftLoginForm;
	
	@Override
	public void init() {
		window = new Window("Web Foot Tournament");

        // Create the window...
        final Window subwindow = new Window("Login");
        // ...and make it modal
        subwindow.setModal(true);
        subwindow.setClosable(false);
        subwindow.setResizable(false);
        subwindow.setWidth("40%");
        subwindow.setHeight("40%");

        // Configure the windws layout; by default a VerticalLayout
        VerticalLayout layout = new VerticalLayout();
        subwindow.setContent(layout);
        layout.setMargin(true);
        layout.setSpacing(true);

        
		wftLoginForm.setWidth("30%");
		wftLoginForm.setHeight("30%");
        layout.addComponent(wftLoginForm);
        layout.setComponentAlignment(wftLoginForm, new Alignment(Bits.ALIGNMENT_HORIZONTAL_CENTER|Bits.ALIGNMENT_VERTICAL_CENTER));

        window.addWindow(subwindow);

		setMainWindow(window);

	}

}

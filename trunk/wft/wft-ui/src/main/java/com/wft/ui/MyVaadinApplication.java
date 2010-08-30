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

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.wft.service.FooService;
import com.wft.service.services.AuthenticationService;

/**
 * The Application's "main" class
 */
@Component(value = "myVaadinApplication")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application {
	private Window window;

	@Autowired
	private transient AuthenticationService authenticationService;

	@Override
	public void init() {
		window = new Window("My Vaadin Application");
		setMainWindow(window);
		Button b = new Button("Click Me");
		b.addListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				authenticationService.authenticate("admin", "admin");
			}
		});
		window.addComponent(b);
	}

}

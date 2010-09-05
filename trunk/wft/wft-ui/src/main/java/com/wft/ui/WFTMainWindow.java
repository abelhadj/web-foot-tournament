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

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.wft.service.services.AuthenticationService;

/**
 * The Application's "main" class
 */
@Component(value = "wftMainWindow")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WFTMainWindow extends Window {

	@Autowired
	private transient AuthenticationService authenticationService;

	public WFTMainWindow() {
		super();
		Button b = new Button("Logout");
		b.addListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				authenticationService.logout();

				URL url = getApplication().getMainWindow().getURL();
				URL logoutURL;
				try {
					String file = url.getFile();
					String logoutFile = file.substring(0, file.indexOf("/app"))
							+ "/login";
					logoutURL = new URL(url.getProtocol(), url.getHost(),
							url.getPort(), logoutFile);
					System.out.println("logoutURL = " + logoutURL.toString());
					getApplication().setLogoutURL(logoutURL.toString());
					getApplication().close();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		addComponent(b);
	}

}

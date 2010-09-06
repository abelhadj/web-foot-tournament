package com.wft.ui.welcome.profile;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.wft.service.services.AuthenticationService;

@Component(value = "wftWelcomeProfilePanel")
@Scope(value = "prototype")
@SuppressWarnings("serial")
public class WFTWelcomeProfilePanel extends Panel {
	
	@Autowired
	private transient AuthenticationService authenticationService;

	public WFTWelcomeProfilePanel() {
		super("Profile");
		setSizeFull();
		
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

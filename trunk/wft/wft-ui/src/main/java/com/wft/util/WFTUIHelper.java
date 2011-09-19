package com.wft.util;

import com.wft.ui.ApplicationServiceProvider;
import com.wft.ui.WebFootTournamentApplication;
import com.wft.ui.welcome.WFTWelcomeMainPanel;
import com.wft.ui.welcome.WFTWelcomeWindow;

public class WFTUIHelper {
	
	public static ApplicationServiceProvider getApplicationServiceProvider() {
		return (ApplicationServiceProvider) ApplicationHolder.getApplication();
	}
	
	public static WebFootTournamentApplication getWebFootTournamentApplication() {
		return (WebFootTournamentApplication) ApplicationHolder.getApplication();
	}

	public static WFTWelcomeWindow getWftWelcomeWindow() {
		return (WFTWelcomeWindow) getWebFootTournamentApplication().getMainWindow();
	}
	
	public static WFTWelcomeMainPanel getWelcomeMainPanel() {
		return getWftWelcomeWindow().getWftWelcomeMainPanel();
	}
}

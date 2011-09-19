package com.wft.ui;

import com.wft.service.services.ITournamentService;
import com.wft.service.services.IUserService;

public interface ApplicationServiceProvider {

	IUserService getUserService();
	ITournamentService getTournamentService();
}

package com.wft.ui.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Vbox;

import com.wft.service.services.ITeamRepositoryService;

public class TournamentsAfterCompose extends Vbox implements AfterCompose {

	@Autowired
	ITeamRepositoryService teamRepositoryService;

	public void afterCompose() {
		Combobox teamRepoNames_cb = (Combobox) this.getFellow("teamRepoNames");
//		teamRepoNames_cb.setSelectedIndex(0);
	}
	

}

package com.wft.ui.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import com.wft.service.services.ITeamRepositoryService;

public class TournamentsProfileComposer extends GenericForwardComposer {

	@Autowired
	ITeamRepositoryService teamRepositoryService;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		comp.setAttribute("teamRepoNames", teamRepositoryService.getAllRepositoriesName());
	}

}

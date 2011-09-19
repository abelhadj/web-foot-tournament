package com.wft.service.dao.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wft.model.tournament.Tournament;
import com.wft.service.dao.ITournamentDAO;

@Service
@Transactional(propagation = Propagation.MANDATORY)
public class TournamentDAO extends BaseDaoHibernate<Tournament> implements
		ITournamentDAO {

	public TournamentDAO() {
		super(Tournament.class);
	}

}

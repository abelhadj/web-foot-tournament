package com.wft.model.tournament;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.wft.model.BaseEntity;
import com.wft.model.team.Team;
import com.wft.model.user.User;

@Entity
public class OrganizingRequest extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private User user;

	public OrganizingRequest() {
		super();
	}

}

package com.wft.model.team;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.wft.model.BaseEntity;

@Entity
public class TeamPlayer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String firstName;
	
	private String lastName;
}

package com.wft.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.ForceDiscriminator;

@Entity
@DiscriminatorValue(value = "ROLE_GAMER")
@ForceDiscriminator
public class Gamer extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Gamer() {
		super();
	}

}

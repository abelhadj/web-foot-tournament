package com.wft.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.ForceDiscriminator;

@Entity
@DiscriminatorValue(value="ROLE_GAMER")
@ForceDiscriminator
public class Gamer extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2757500216253370205L;

	public Gamer() {
		super();
	}

	public Gamer(String login, String password) {
		super(login, password);
	}

}

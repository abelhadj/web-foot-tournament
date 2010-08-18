package com.wft.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.ForceDiscriminator;

@Entity
@DiscriminatorValue(value="ROLE_ORGANIZER")
@ForceDiscriminator
public class Organizer extends User {

	
	private Organizer() {
		super();
	}

	public Organizer(String login, String password) {
		super(login, password);
	}

}

package com.wft.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.ForceDiscriminator;

@Entity
@DiscriminatorValue(value="ROLE_GAMER")
@ForceDiscriminator
public class Gamer extends User {

	private Gamer() {
		super();
	}

	public Gamer(String login, String password) {
		super(login, password);
	}

}

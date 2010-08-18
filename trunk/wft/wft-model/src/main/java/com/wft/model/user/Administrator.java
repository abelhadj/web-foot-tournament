package com.wft.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.ForceDiscriminator;

@Entity
@DiscriminatorValue(value="ROLE_ADMINISTRATOR")
@ForceDiscriminator
public class Administrator extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4070529120457672054L;

	public Administrator() {
//		this.role = Role.ROLE_ADMINISTRATOR;
	}

	public Administrator(String login, String password) {
		super(login, password);
//		this.role = Role.ROLE_ADMINISTRATOR;
	}
}

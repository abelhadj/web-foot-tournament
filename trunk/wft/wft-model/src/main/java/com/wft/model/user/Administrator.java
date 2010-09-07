package com.wft.model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.ForceDiscriminator;

@Entity
@DiscriminatorValue(value = "ROLE_ADMINISTRATOR")
@ForceDiscriminator
public class Administrator extends Organizer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}

}

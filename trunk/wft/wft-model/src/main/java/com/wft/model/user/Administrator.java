package com.wft.model.user;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

public class Administrator extends User {

	public Administrator(String login, String password) {
		super(login, password);
		this.role = Role.ROLE_ADMINISTRATOR;
	}
}

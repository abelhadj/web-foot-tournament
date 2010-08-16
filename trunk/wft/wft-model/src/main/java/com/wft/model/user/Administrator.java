package com.wft.model.user;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Entity
//@Table(name = "ADMINISTRATOR")
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Administrator extends User {

	@Override
	protected Role getRole() {
		return Role.ROLE_ADMINISTRATOR;
	}

	public Administrator(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}
}

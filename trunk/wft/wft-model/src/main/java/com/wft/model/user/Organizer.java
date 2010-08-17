package com.wft.model.user;

public class Organizer extends User {

	public Organizer(String login, String password) {
		super(login, password);
		this.role = Role.ROLE_ORGANIZER;
	}

}

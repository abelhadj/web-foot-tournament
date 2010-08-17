package com.wft.model.user;

public class Gamer extends User {

	public Gamer(String login, String password) {
		super(login, password);
		this.role = Role.ROLE_GAMER;
	}

}

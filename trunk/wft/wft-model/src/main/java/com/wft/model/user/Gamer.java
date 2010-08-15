package com.wft.model.user;

public class Gamer extends User {
	@Override
	protected Role getRole() {
		return Role.ROLE_GAMER;
	}

}

package com.wft.model.user;

public class Organizer extends User {
	@Override
	protected Role getRole() {
		return Role.ROLE_ORGANIZER;
	}

}

package com.wft.model.user;

public class Administrator extends User {

	@Override
	protected Role getRole() {
		return Role.ROLE_ADMINISTRATOR;
	}

}

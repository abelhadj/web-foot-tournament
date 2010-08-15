package com.wft.model.user;

import java.util.Date;

public abstract class User {
	
	private String login;
	private String password;
	
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String mailAdress;

	protected abstract Role getRole();
}

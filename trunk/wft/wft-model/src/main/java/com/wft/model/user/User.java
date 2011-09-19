package com.wft.model.user;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.ForceDiscriminator;

import com.wft.model.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING, columnDefinition = "VARCHAR(32) DEFAULT \"ROLE_USER\"", length = 32)
@DiscriminatorValue(value = "ROLE_USER")
@ForceDiscriminator
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String login;

	private String password;

	private String firstName;

	private String lastName;

	private Date birthDate;

	private String mailAdress;

	public User() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMailAdress() {
		return mailAdress;
	}

	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	public String getRoleName() {
		if (this instanceof Administrator) {
			return "ROLE_ADMINISTRATOR";
		} else if (this instanceof Organizer) {
			return "ROLE_ADMINISTRATOR";
		} else if (this instanceof Gamer) {
			return "ROLE_ADMINISTRATOR";
		}
		return "ROLE_USER";
	}
}

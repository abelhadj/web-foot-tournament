package com.wft.model.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForceDiscriminator;

import com.wft.model.tournament.Tournament;

@Entity
@DiscriminatorValue(value = "ROLE_GAMER")
@ForceDiscriminator
public class Gamer extends User {
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Tournament> tournamentsPlayed;
	
	private static final long serialVersionUID = 1L;

	public Gamer() {
		super();
	}

}

package com.wft.model.tournament;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.ForceDiscriminator;

import net.sf.gilead.pojo.java5.LightEntity;

import com.wft.model.user.Organizer;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING, columnDefinition = "VARCHAR(32) DEFAULT \"TOURNAMENT\"", length = 32)
@DiscriminatorValue(value = "TOURNAMENT")
@ForceDiscriminator
public abstract class Tournament extends LightEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Organizer> organizers;

	private Boolean autoAcceptPlayers;

	public abstract List<PlayingTeam> getPlayingTeams();
}

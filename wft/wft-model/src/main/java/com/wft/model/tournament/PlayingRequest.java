package com.wft.model.tournament;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import net.sf.gilead.pojo.java5.LightEntity;

import com.wft.model.team.Team;
import com.wft.model.user.Gamer;
import com.wft.model.user.User;

@Entity
public class PlayingRequest extends LightEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private Tournament tournament;

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private Team team;

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private User user;

	public PlayingRequest() {
		super();
	}

}

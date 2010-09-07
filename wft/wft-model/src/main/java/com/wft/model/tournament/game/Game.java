package com.wft.model.tournament.game;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import net.sf.gilead.pojo.java5.LightEntity;

import com.wft.model.tournament.PlayingTeam;

@Entity
public class Game extends LightEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private PlayingTeam hostingTeam;

	@OneToOne(fetch = FetchType.LAZY, cascade = {})
	private PlayingTeam visitorTeam;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private GameScore finalScore;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private GameScore halfTimeScore;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private GameScore penaltyKicksScore;

}

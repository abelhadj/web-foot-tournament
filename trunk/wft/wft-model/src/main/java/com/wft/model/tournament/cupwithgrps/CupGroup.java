package com.wft.model.tournament.cupwithgrps;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import net.sf.gilead.pojo.java5.LightEntity;

import com.wft.model.tournament.PlayingTeam;

@Entity
public class CupGroup extends LightEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer groupNumber;
	

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PlayingTeam> playingTeams;

	public List<PlayingTeam> getPlayingTeams() {
		return playingTeams;
	}

}

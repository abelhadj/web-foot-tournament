package com.wft.model.tournament.game;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.sf.gilead.pojo.java5.LightEntity;

@Entity
public class GameScore extends LightEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer hostingScore;

	private Integer visitorScore;

	public Integer getHostingScore() {
		return hostingScore;
	}

	public void setHostingScore(Integer hostingScore) {
		this.hostingScore = hostingScore;
	}

	public Integer getVisitorScore() {
		return visitorScore;
	}

	public void setVisitorScore(Integer visitorScore) {
		this.visitorScore = visitorScore;
	}

}

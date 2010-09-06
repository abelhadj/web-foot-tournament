package com.wft.model.tournament.match;

import java.io.Serializable;

import net.sf.gilead.pojo.java5.LightEntity;

public class MatchScore extends LightEntity implements Serializable {
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

package com.wft.model.tournament.match;

import java.io.Serializable;

import com.wft.model.tournament.PlayingTeam;
import com.wft.model.tournament.Tournament;

import net.sf.gilead.pojo.java5.LightEntity;

public class Match extends LightEntity implements Serializable {

	private Tournament associatedTournament;
	
	private PlayingTeam hostingTeam;
	private PlayingTeam visitorTeam;

	private MatchScore finalScore;
	private MatchScore halfTimeScore;
	private MatchScore penaltyKicksScore;

}

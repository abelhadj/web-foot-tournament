package com.wft.service.services.tournament;

import java.util.Vector;

public class TournamentHelper {
	/**
	 * 
	 * @param nbTeams number of teams in the cup
	 * @return result<br/>
	 * 	with :<br/>
	 * 		result[0] = n is the depth of the cup (i.e. nbTeams <= 2^n)<br/>
	 * 		result[2] = number of teams in the n level<br/>
	 * 		result[1] = number of teams in the n-1 level<br/>
	 */
	public static final Vector<Integer> computeCupStructure(int nbTeams) {
		Vector<Integer> result = new Vector<Integer>();
		
		int depth = (int) Math.floor((Math.log(nbTeams)/Math.log(2)));

		if (nbTeams > Math.pow(2, depth)) {
			int diff = nbTeams-(int)(Math.pow(2, depth));
			result.add(depth+1);
			result.add(2*diff);
			result.add((int)(Math.pow(2, depth))-diff);
		} else {
			result.add(depth);
			result.add((int)Math.pow(2, depth));
			result.add(0);
		}
		
		return result;
	}
	
}

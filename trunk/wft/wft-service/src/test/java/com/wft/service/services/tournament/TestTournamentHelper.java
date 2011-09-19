package com.wft.service.services.tournament;

import java.util.Vector;

import junit.framework.TestCase;

public class TestTournamentHelper extends TestCase {
	
	public void testcomputeNumberOfTeamsInTheTwoLastCupLevel() {
		Vector<Integer> expected = null;

		// 4 -> 2,4,0
		expected = new Vector<Integer>(); expected.add(2); expected.add(4); expected.add(0);
		assertEquals(expected, TournamentHelper.computeCupStructure(4));

		// 5 -> 3,2,3
		expected = new Vector<Integer>(); expected.add(3); expected.add(2); expected.add(3);
		assertEquals(expected, TournamentHelper.computeCupStructure(5));

		// 6 -> 3,4,2
		expected = new Vector<Integer>(); expected.add(3); expected.add(4); expected.add(2);
		assertEquals(expected, TournamentHelper.computeCupStructure(6));

		// 7 -> 3,6,1
		expected = new Vector<Integer>(); expected.add(3); expected.add(6); expected.add(1);
		assertEquals(expected, TournamentHelper.computeCupStructure(7));

		// 8 -> 3,8,0
		expected = new Vector<Integer>(); expected.add(3); expected.add(8); expected.add(0);
		assertEquals(expected, TournamentHelper.computeCupStructure(8));

		// 9 -> 4,2,7
		expected = new Vector<Integer>(); expected.add(4); expected.add(2); expected.add(7);
		assertEquals(expected, TournamentHelper.computeCupStructure(9));
	}

}

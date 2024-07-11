package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;

import levelPieces.Archer;
import levelPieces.EldritchHorror;
import levelPieces.Rock;

/*
 * @class TestInteractions
 * @author Andrew Bernklau
 * @author Peyton Calvert
 * @sources
 * @collaborators
 * 
 * Purpose: To test the movements of all pieces that move within our game of KerPlop
 */
public class TestMovingPieces {
	
	/*
        The archer tries to stay 2 tiles away from the player at all times and will jump to the next avalible tile if the player is too close or too far.
        To test we have setup a level with checks after each move to make sure the archer made the correct choice.
	 */
	@Test
	public void testArcherMove() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Archer archer = new Archer(20);
		gameBoard[20] = archer;
		//level looks like |P|R| | | | |R| | | | |R| | | |R|R| | |R|A|
		// Create 6 rocks to place on the board for Archer to move around
		Rock rock1 = new Rock();
		gameBoard[19] = rock1;

		Rock rock2 = new Rock();
		gameBoard[16] = rock2;

		Rock rock3 = new Rock();
		gameBoard[15] = rock3;

		Rock rock4 = new Rock();
		gameBoard[11] = rock4;

		Rock rock5 = new Rock();
		gameBoard[6] = rock5;

		Rock rock6 = new Rock();
		gameBoard[1] = rock6;

		// Move Archer and check every movement it makes
		archer.move(gameBoard,0);
		assert(archer.getLocation()==18);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==17);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==14);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==13);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==12);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==10);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==9);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==8);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==7);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==5);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==4);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==3);
		archer.move(gameBoard,0);
		assert(archer.getLocation()==2);

	}

	/*
	 * Tests random motion, used by both the EldritchHorror.
	 * Strategy: 
	 * - Place pieces in all spaces EXCEPT 0, 6, 12, 13, 20.
	 * - Ensures both end spots (0 and 20) are open.
	 * - Same piece is used in all spaces, as piece identity doesn't matter.
	 * - Set player location to space 13.
	 * - Call move function many times, ensure each open space is chosen
	 *   (13 is "open" but has the player, so it should NOT be chosen)
	 */
	@Test
	public void testEldritchMovement() {
		// Each test will create its own gameBoard
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		// Start with 1, leaves 0 open
		for (int i=1;i<=5; i++)
			gameBoard[i] = new Rock();
		// Leave 6 open
		for (int i=7; i<=11; i++)
			gameBoard[i] = new Rock();
		// Leave 12, 13 and 20 open, assume player in 13
		for (int i=14; i<20; i++)
			gameBoard[i] = new Rock();
		// Place EldritchHorror in an open space - 6
		// Note that EldritchHorror location will be updated via move method, 
		// so occasionally location 6 will be open and may be chosen
		EldritchHorror eh = new EldritchHorror(6);
		gameBoard[6] = eh;
		int count0 = 0;
		int count6 = 0;
		int count12 = 0;
		int count20 = 0;
		for (int i=0; i<200; i++) {
			eh.move(gameBoard, 13);
			int loc = eh.getLocation();
			// ensure no other space is chosen
			if (loc != 0 && loc != 6 && loc != 12 && loc != 20)
				fail("Invalid square selected");
			// counters to ensure every valid option is chosen
			if (loc == 0) count0++;
			if (loc == 6) count6++;
			if (loc == 12) count12++;
			if (loc == 20) count20++;
		}
		// Ensure each option is randomly chosen some number of times. 
		assert(count0 > 1);
		assert(count6 > 1);
		assert(count12 > 1);
		assert(count20 > 1);		
	}
}

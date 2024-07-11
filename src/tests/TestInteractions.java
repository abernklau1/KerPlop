package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Archer;
import levelPieces.Coin;
import levelPieces.EldritchHorror;
import levelPieces.LandMine;
import levelPieces.WarpPad;

/*
 * @class TestInteractions
 * @author Andrew Bernklau
 * @author Peyton Calvert
 * @sources
 * @collaborators
 * 
 * Purpose: To test the interactions of interactive pieces in our game of KerPlop
 */
class TestInteractions {

	/*
		The Archer can only hit the player within 2 tiles or do nothing. 
		Strategy: Test archer in several different positions and make sure it interacts correctly with the player.
	*/
	@Test
	public void testArcherInt(){
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		//first test the archer can shoot the player correctly
		Archer archer = new Archer(5);
		gameBoard[archer.getLocation()] = archer;
		assertEquals(InteractionResult.HIT, archer.interact(gameBoard, 3));
		assertEquals(InteractionResult.HIT, archer.interact(gameBoard, 4));
		assertEquals(InteractionResult.HIT, archer.interact(gameBoard, 6));
		assertEquals(InteractionResult.HIT, archer.interact(gameBoard, 7));
		
		//make sure the archer misses when he should
		for (int i=0; i<3; i++)
			assertEquals(InteractionResult.NONE, archer.interact(gameBoard, i));
		for (int i=8; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, archer.interact(gameBoard, i));
	}
	
	/*
		The coin can only give the player a point if they share the same location and does nothing otherwise.
		Strategy: test the coin with every possible position of the player and make sure it only reacts when the player is standing on it.
	*/
	@Test
	public void testCoinInt(){
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		// Check if Coin interaction works properly when on the same space
		Coin coin = new Coin(7);
		gameBoard[coin.getLocation()] = coin;
		for(int i=0;i < gameBoard.length;i++){
			if(i == 7){
				assertEquals(InteractionResult.GET_POINT, coin.interact(gameBoard, 7));
			} else {
				assertEquals(InteractionResult.NONE, coin.interact(gameBoard, i));
			}
		}
	}
	/*
		EH does not interact with the player ever and only screams when its within 1 tile
		This test should print the statement The Eldritch Horror screams loudly but does nothing. 3 times and checks to make sure the EH does NONE. 
	*/
	@Test
	public void testEldHorInt(){
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		EldritchHorror eldy = new EldritchHorror(5);
		gameBoard[eldy.getLocation()] = eldy;
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			assertEquals(InteractionResult.NONE, eldy.interact(gameBoard, i));
		}
	}
	/*
		LandMine does nothing unless the player steps on it in which case it instantly kills them.
		This test makes sure the landmine functions correctly by checking a static mine to every possible player position.
	*/
	@Test
	public void testLandMineInt(){
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		LandMine lm = new LandMine(10);
		gameBoard[lm.getLocation()] = lm;

		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 10) {
				assertEquals(InteractionResult.KILL, lm.interact(gameBoard, i));
			} else {
				assertEquals(InteractionResult.NONE, lm.interact(gameBoard, i));
			}
		}
		
	}
	/*
		The warp pad teleports the player to the next level if they share the same location and does nothing otherwise. 
		This tests every player position in reference to the warp pad at index 10.
	*/
	@Test
	public void testWarpPadInt(){
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		WarpPad wp = new WarpPad(10);
		gameBoard[wp.getLocation()] = wp;

		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i == 10) {
				assertEquals(InteractionResult.ADVANCE, wp.interact(gameBoard, i));
			} else {
				assertEquals(InteractionResult.NONE, wp.interact(gameBoard, i));
			}
		}
	}
}

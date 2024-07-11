package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.GameEngine;

/*
 * @class LevelSetup
 * @author Andrew Bernklau
 * @author Peyton Calvert
 * @sources https://www.geeksforgeeks.org/generating-random-numbers-in-java/
 * @collaborators
 * 
 * Purpose: To setup individual levels, the location of each piece on the game board, and the movable/interactive pieces of the game.
 */

public class LevelSetup {

	// Game pieces
	Rock R1;
	LandMine L1;
	Coin C1;
	Archer A1;
	EldritchHorror EH1;
	WarpPad WP1;

	private Drawable [] gameBoard;

	private ArrayList<Moveable> movingPieces;

	private ArrayList<GamePiece> interactingPieces;

	/*
	 * Constructor to initialize gameBoard, movable/interactive pieces arrayLists and the position of the rock on the game board
	 */
	public LevelSetup() {
		gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece> ();
		R1 = new Rock();
		gameBoard[0] = R1;
	}

	/*
	 * A method to call another method that creates each level based on the provided levelNum
	 */
	public void createLevel(int levelNum) {
		//display the level
		if (levelNum == 1) {
			level1();
		} else {
			level2();
		}
	}

	public Drawable[] getBoard() {
		return gameBoard;
	}

	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		return GameEngine.BOARD_SIZE / 2;
	}

	/*
	 * A method to setup the first level's game board
	 */
	private void level1() {

		// Create level pieces
		L1 = new LandMine(4);
		C1 = new Coin(3);
		A1 = new Archer(14);
		EH1 = new EldritchHorror(20);
		WP1 = new WarpPad(7);

		// Populate game board
		gameBoard[L1.getLocation()] = L1;
		gameBoard[C1.getLocation()] = C1;
		gameBoard[A1.getLocation()] = A1;
		gameBoard[EH1.getLocation()] = EH1;
		gameBoard[WP1.getLocation()] = WP1;

		// Populate the moving/interacting pieces ArrayLists
		movingPieces.add(A1);
		movingPieces.add(EH1);

		interactingPieces.add(L1);
		interactingPieces.add(EH1);
		interactingPieces.add(A1);
		interactingPieces.add(C1);
		interactingPieces.add(WP1);

	}

	/*
	 * A method to setup the second level's game board
	 */
	private void level2() {

		// Reset the game board
		for(int i = 0; i <GameEngine.BOARD_SIZE; i++){
			gameBoard[i] = null;
		}

		// Create level pieces
		L1.setLocation(9);;
		C1.setLocation(19);
		A1.setLocation(16);
		WP1.setLocation(14);
		EH1.setLocation(2);

		// Populate game board
		gameBoard[0] = R1;
		gameBoard[L1.getLocation()] = L1;
		gameBoard[C1.getLocation()] = C1;
		gameBoard[A1.getLocation()] = A1;
		gameBoard[EH1.getLocation()] = EH1;
		gameBoard[WP1.getLocation()] = WP1;
		movingPieces.clear();
		interactingPieces.clear();

		// Populate the moving/interacting pieces ArrayLists
		movingPieces.add(A1);
		movingPieces.add(EH1);

		interactingPieces.add(L1);
		interactingPieces.add(EH1);
		interactingPieces.add(A1);
		interactingPieces.add(C1);
		interactingPieces.add(WP1);

	}

}

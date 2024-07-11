package levelPieces;

import gameEngine.*;
import java.util.Random;

/*
 * @class EldritchHorror
 * @author Andrew Bernklau
 * @author Peyton Calvert
 * @sources https://www.geeksforgeeks.org/generating-random-numbers-in-java/
 * @collaborators
 * 
 * Purpose: To create a random moving game piece that screams at the player when near
 */
public class EldritchHorror extends GamePiece implements Moveable {

	private static Random rand = new Random(); // Random object to place object in random position
	private static final char symbol = 'Y';
	private static final String label = "Eldritch Horror";

	/*
	 * Constructor that calls super constructor to initialize EldritchHorror at the specified location
	 */
	public EldritchHorror(int location) {
		super(symbol, label, location);
	}

	/*
	 * Overrides the GamePiece's abstract move method to place the EldritchHorror in a random place on the game board
	 */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) { 

		int newLocation;

		// Creates a random integer, then makes sure the newLocation is not on another piece
		do {
			newLocation =  rand.nextInt((20- 1) + 1) + 1;
		}
		while(gameBoard[newLocation] != null || newLocation == playerLocation);

		/* 
		 * Sets the original location of the piece to null,
		 * then places the piece on the game board at the new location
		 */
		gameBoard[this.getLocation()] = null;
		this.setLocation(newLocation);
		gameBoard[newLocation] = this;

	}

	/*
	 * Overrides the GamePiece's abstract interact method to provide the EldritchHorror interaction
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {

		// Prints out that it screams at the player if within 1 space but does nothing else
		if(Math.abs(playerLocation-super.getLocation()) <= 1){
			System.out.println("The Eldritch Horror screams loudly but does nothing.");
		}
		return InteractionResult.NONE;
	}

}

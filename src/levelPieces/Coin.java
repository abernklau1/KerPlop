package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * @class Coin
 * @author Andrew Bernklau
 * @author Peyton Calvert
 * @sources https://www.geeksforgeeks.org/generating-random-numbers-in-java/
 * @collaborators
 * 
 * Purpose: To create a game piece that gives points if the player lands on it
 */
public class Coin extends GamePiece {
	private static final char symbol = 'o';
	private static final String label = "Coin";

	/*
	 * Constructor that calls super constructor to initialize Coin at the specified location
	 */
	public Coin(int location) {
		super(symbol, label, location);

	}

	/*
	 * If the player grabs the coin they get a point, nothing otherwise.
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == super.getLocation()){
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
}

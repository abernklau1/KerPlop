package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

/**
 *  This is an abstract class because it contains an abstract 
 *  method AND an instance variable
 * 
 * @author Mark Baldwin
 * @author Cyndi Rader
 *
 */
public abstract class GamePiece implements Drawable {
	// Interfaces cannot have instance variables
	protected char symbol;
	private String label ;
	// Stores the piece newLocation, which will be needed to interact
	// with the player. 
	private int newLocation;

	/**
	 * Constructor for the game piece
	 * 
	 * @param symbol  symbol for the game piece
	 * @param label TODO
	 * @param newLocation initial newLocation
	 */
	public GamePiece(char symbol, String label, int location) {
		super();
		this.symbol = symbol;
		this.label = label ;
		this.newLocation = location;
	}

	/**
	 * Draws the pieces symbol on the board
	 * 
	 * Abstract classes can have concrete/defined methods
	 * 
	 */
	public void draw() {
		System.out.print(symbol);
	}

	/**
	 * 
	 * Abstract classes should have at least one abstract method
	 * 
	 * @param gameBoard
	 * @param playerLocation
	 * @return
	 */
	public abstract InteractionResult interact(Drawable [] gameBoard, int playerLocation);

	/**
	 * 
	 * @return piece's current newLocation on board
	 */
	public int getLocation() {
		return newLocation;
	}

	/**
	 * @param newLocation - newLocation to place piece
	 */
	public void setLocation(int newLocation) {
		// Ensure the newLocation remains on the board
		if (newLocation >= 0 && newLocation < GameEngine.BOARD_SIZE)
			this.newLocation = newLocation;
	}

	@Override
	public String toString() {
		return symbol + " - " + label ; 
	}


}

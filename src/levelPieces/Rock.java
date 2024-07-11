package levelPieces;

import gameEngine.Drawable;

/*
 * @class Rock
 * @author Andrew Bernklau
 * @author Peyton Calvert
 * @sources https://www.geeksforgeeks.org/generating-random-numbers-in-java/
 * @collaborators
 * 
 * Purpose: To create a game piece does absolutely nothing but sit on the board
 */
public class Rock implements Drawable {

	private final static char symbol= 'R';

	/*
	 * Overrides the Drawable abstract draw method to print it's symbol to the console
	 */
	@Override
	public void draw() {
		System.out.print(symbol);
	}

}

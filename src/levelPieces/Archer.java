package levelPieces;
import gameEngine.*;


/*
 * @class Archer
 * @author Andrew Bernklau
 * @author Peyton Calvert
 * @sources
 * @collaborators
 * 
 * Purpose: To create a game piece that inches closer to the player and hits the player
 */
public class Archer extends GamePiece implements Moveable {

	private final static char symbol = 'A';
	private final static String label = "Archer";

	/*
	 * Constructor that calls super constructor to initialize Archer at the specified location
	 */
	public Archer(int location) {
		super(symbol, label, location);
	}

	/*
	 * The Archer stays greater than or equal to 2 spots away from the player
	 */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {

		// Find distance between player and Archer
		int distance = super.getLocation() - playerLocation;

		int newLocation = super.getLocation(); 

		// Check if the Archer's new space is occupied and increment/decrement newLocation
		while(gameBoard[newLocation] != null) {
			if (distance > 1) {
				newLocation--;
			} else {
				newLocation++;
			}
		}

		/* 
		 * Sets the original location of the piece to null,
		 * then places the piece on the game board at the new location
		 */
		gameBoard[super.getLocation()] = null;
		super.setLocation(newLocation);
		gameBoard[newLocation] = this;

	}

	/*
	 *	The Archer checks if it is within 2 tiles of the player in any direction and if it is they hit the player.
	 */
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation){
		if(Math.abs(super.getLocation() - playerLocation) <= 2){
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}

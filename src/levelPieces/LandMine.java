package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * @class Archer
 * @author Andrew Bernklau
 * @author Peyton Calvert
 * @sources 
 * @collaborators
 * 
 * Purpose: To create a game piece that does not move but kills the player if the player steps on it.
 */
public class LandMine extends GamePiece {
	private final static char symbol = '.';
	private  final static String label = "Landmine";

	/*
	 * Constructor that calls super constructor to initialize LandMine at the specified location
	 */
	public LandMine(int location) {
		super(symbol, label, location);

	}

	/*
	 * If the player touches the land mine they instantly die.
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == super.getLocation()) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}

}

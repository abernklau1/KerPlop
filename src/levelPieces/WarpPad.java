package levelPieces;
import gameEngine.*;

/*
 * @class WarpPad
 * @author Andrew Bernklau
 * @author Peyton Calvert
 * @sources https://www.geeksforgeeks.org/generating-random-numbers-in-java/
 * @collaborators
 * 
 * Purpose: To create a piece that warps the player to the next level
 */
public class WarpPad extends GamePiece{
	private final static char symbol = 'w';
	private final static String label = "Warp Pad";

	/*
	 * Constructor that calls super constructor to initialize WarpPad at the specified location
	 */
	public WarpPad(int location) {
		super(symbol, label, location);

	}

	/*
	 * When the player steps on the warp pad, they advance
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(playerLocation == super.getLocation()){
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}
}

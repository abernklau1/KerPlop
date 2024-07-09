package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Coin extends GamePiece {
	private static final char symbol = 'o';
	private static final String label = "Coin";

	public Coin(int location) {
		super(symbol, label, location);

	}
	
	/*
		If the player grabs the coin they get a point, nothing otherwise.
	*/
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == super.getLocation()){
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
}

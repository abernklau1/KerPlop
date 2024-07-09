package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class LandMine extends GamePiece {
	private final static char symbol = '.';
	private final static String label = "Landmine";
	
	public LandMine(int location) {
		super(symbol, label, location);
		
	}
	/*
		If the player touches the landmine they instantly die.
	*/
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (playerLocation == super.getLocation()) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}

}

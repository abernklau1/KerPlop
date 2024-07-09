package levelPieces;
import gameEngine.*;

public class WarpPad extends GamePiece{
    private final static char symbol = 'w';
	private final static String label = "Warp Pad";
	
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
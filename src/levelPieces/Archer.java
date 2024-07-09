package levelPieces;
import gameEngine.*;

public class Archer extends GamePiece implements Moveable {
	private final static char symbol = 'A';
	private final static String label = "Archer";
	
	public Archer(int location) {
		super(symbol, label, location);
	}
	
	/*
	 * The Archer stays greater than or equal to 2 spots away from the player
	 */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int distance = super.getLocation() - playerLocation;
		int location = 0;
		
		if (distance > 2) {
			location = super.getLocation() - 1;
		}
		if (distance < -2) {
			location = super.getLocation() + 1;
		}
		
		super.setLocation(location);
	}
	
	/*
	*	The Archer checks if it is within 2 tiles of the player in any direction and if it is they shoot they player. Otherwise 
	*/
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation){
		if(Math.abs(super.getLocation()-playerLocation) <= 2){
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}
}

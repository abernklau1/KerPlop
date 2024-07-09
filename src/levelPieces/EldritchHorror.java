package levelPieces;

import gameEngine.*;
import java.util.Random;

public class EldritchHorror extends GamePiece implements Moveable {
	
	private static final char symbol = 'Y';
	private static final String label = "Eldritch Horror";

	public EldritchHorror(int location) {
		super(symbol, label, location);
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) { 
		Random rand = new Random();
        int toMove = rand.nextInt(20);
		super.setLocation(toMove);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		if(Math.abs(playerLocation-super.getLocation())<=1){
			System.out.println("The Eldritch Horror screams loudly but does nothing.");
		}
		return InteractionResult.NONE;
	}

}

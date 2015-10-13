package model;

public class Ship extends Element {

	Direction a_direction;
	
	public Ship(GameBoard i_board, int i_posX, int i_posY, Direction i_direction) {
		super(i_board, i_posX, i_posY);
		a_direction = i_direction;
	}
	
	public String get_direction(){
		return a_direction.toString();
	}
	public void move(Direction a_direction){
		//pour l'instant, ne fait rien si le robot ne peux pas avancer
		//a_direction.move_straight();
		int posX = 0, posY = 0;
		
		// modification de la position
		if(a_direction == Direction.NORTH){
			posY = a_posY-1;
		}
		if(a_direction == Direction.SOUTH){
			posY = a_posY+1;
		}
		if(a_direction == Direction.EAST){
			posX = a_posX+1;
		}
		if(a_direction == Direction.WEST){
			posX = a_posX-1;
		}
		
		a_board.move(this, posX, posY);
	}

}

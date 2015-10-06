package model;

public class Ship extends Element {

	Direction a_direction;
	
	public Ship(GameBoard i_board, Direction i_direction) {
		super(i_board);
		a_direction = i_direction;
	}

}

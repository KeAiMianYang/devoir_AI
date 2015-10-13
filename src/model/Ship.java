package model;
/**
 * Classe representant un vaisseau/moto
 * @author Jasmine
 *
 */
public class Ship extends Element {

	Direction a_direction;
	/**
	 * Constructeur d'un vaisseau
	 * @param i_board
	 * @param i_posX
	 * @param i_posY
	 * @param i_direction
	 */
	public Ship(GameBoard i_board, int i_posX, int i_posY, Direction i_direction) {
		super(i_board, i_posX, i_posY);
		a_direction = i_direction;
	}
	/**
	 * renvoit la direction du vaisseau
	 * @return
	 */
	public String get_direction(){
		return a_direction.toString();
	}
	/**
	 * Bouge le vaisseau selon la direction
	 * @param a_direction
	 */
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

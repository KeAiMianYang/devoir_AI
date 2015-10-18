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
	 * @param i_direction
	 */
	public void move(Direction i_direction){
		//pour l'instant, ne fait rien si le robot ne peux pas avancer, exception plutôt?
		//a_direction.move_straight();
		//ne prend pas en compte l'impossibilité de reculer
		int posX = a_posX, posY = a_posY;
		
		// modification de la position
		if(i_direction == Direction.NORTH){
			posX = a_posX-1;
		}
		else if(i_direction == Direction.SOUTH){
			posX = a_posX+1;
		}
		else if(i_direction == Direction.EAST){
			posY = a_posY+1;
		}
		else if(i_direction == Direction.WEST){
			posY = a_posY-1;
		}
		//Le vaisseau ne peux pas se deplacer, soit il y a deja un objet, soit il touche le bord du plateau,
		//Le vaisseau a donc perdu
		if (!a_board.move(this, posX, posY, i_direction)){
			System.out.println("\n Crash, le vaisseau a perdu \n");
		}
	}
	/**
	 * 
	 * @param i_d
	 */
	public void set_direction(Direction i_d) {
		a_direction = i_d;
	}

}

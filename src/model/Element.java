package model;
/**
 * representation d'un element du plateau
 * @author kork
 *
 */
public abstract class Element {
	final GameBoard a_board;
	
	int a_posX;
	int a_posY;
	
	/**
	 * instancie Element
	 * @param i_board le plateau sur lequel est placé l'element. En pratique i_board vaudra "this"
	 */
	public Element (GameBoard i_board){
		a_board = i_board;
	}
	
	/**
	 * renvoit la position X du vaiseau
	 * @return
	 */
	public int get_posX(){
		return a_posX;
	}
	/**
	 * renvoit la position Y du vaiseau
	 * @return
	 */
	public int get_posY(){
		return a_posY;
	}
	/**
	 * modifie la position X du vaiseau
	 * @param i_x
	 */
	public void set_posX(int i_x){
		a_posX = i_x;
	}
	/**
	 * modifie la position X du vaiseau
	 * @param i_y
	 */
	public void set_posY(int i_y){
		a_posY = i_y;
	}
}

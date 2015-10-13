package model;
/**
 * representation d'un element du plateau
 * @author kork
 *
 */
public abstract class Element {
	final GameBoard a_board;
	
	protected int a_posX;
	protected int a_posY;
	
	/**
	 * instancie Element
	 * @param i_board le plateau sur lequel est placé l'element. En pratique i_board vaudra "this"
	 */
	// penser à verifier si un élément est déjà present 
	// dans le tableau avant d'appeler Element()
	public Element (GameBoard i_board, int i_posX, int i_posY){
		a_board = i_board;
		a_posX = i_posX;
		a_posY = i_posY;
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
	@Override
	public String toString(){
		return "posX="+a_posX+" posY="+a_posY;
	}
}

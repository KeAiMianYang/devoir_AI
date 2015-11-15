/**
 * BINOME : 
 * Dupuy-roudel Hugo : 21306151
 * Lebert Jasmine : 21301704
 */
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
	/**
	 * renvoit les positions d'un element dans une chaine de caracteres
	 */
	@Override
	public String toString(){
		return "posX="+a_posX+" posY="+a_posY;
	}
	
	/**
	 * Renvoit une copie de l'element
	 * @param i_board le plateau auquel est lié l'element, forcement différent du plateau d'origine
	 * @return la copie
	 */
	public abstract Element copy(GameBoard i_board);

	public abstract int get_int_value();

	/**
	 * test si deux elements sont égaux
	 * @param i_element l'élement à tester
	 * @return vrai si ils sont égaux, faux sinon
	 */
	public boolean is_equal(Element i_element) {
		boolean samePosition = i_element.get_posX() == get_posX() && i_element.get_posY() == get_posY();
		return samePosition && i_element.get_int_value() == get_int_value(); 
	}
}

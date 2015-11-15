/**
 * BINOME : 
 * Dupuy-roudel Hugo : 21306151
 * Lebert Jasmine : 21301704
 */

package model;
/**
 * Classe representant un element Mur
 *
 */
public class Wall extends Element{

	public Wall(GameBoard i_board, int i_posX, int i_posY) {
		super(i_board, i_posX, i_posY);
	}
	
	@Override
	public String toString(){
		return super.toString()+" -> MUR";
	}
	
	@Override
	public Element copy(GameBoard i_board){
		return new Wall(i_board, a_posX, a_posY);
	}

	@Override
	public int get_int_value() {
		return -1;
	}

}

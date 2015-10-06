package model;
/**
 * classe representant le plateau de jeu
 * @author kork
 *
 */
public class GameBoard {
	Element [][] a_board;
	/**
	 * instancie le plateau de jeu
	 * @param i_x le nombre de lignes du plateau
	 * @param i_y le nombre de colonnes du plateau
	 */
	public GameBoard (int i_x, int i_y){
		i_x = i_x > 10 ? i_x : 10; // si i_x > 10 alors i_x ne change pas, sinon i_x = 10
		i_y = i_y > 10 ? i_y : 10; // idem
		
		a_board = new Element[i_x][i_y];
	}
	
	
}

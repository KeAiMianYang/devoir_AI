package model;
/**
 * classe representant le plateau de jeu
 * @author kork
 *
 */
public class GameBoard {
	protected Element [][] a_board;
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
	/**
	 * ajoute un joueur dans le tableau
	 * @param i_x la coordonnée x
	 * @param i_y la coordonnée x
	 * @param i_d la direction du vaisseau
	 * @return le joueur crée, null si un joueur n'a pas été crée
	 */
	public Player add_player (int i_x, int i_y, Direction i_d){
		Ship o_ship = new Ship(this, i_x, i_y, i_d);
		Player o_player = new Player(o_ship, null); // TODO:TOCHANGE
		if(a_board[i_x][i_y] != null){
			return null;
		}
		a_board[i_x][i_y] = o_ship;
		return o_player;
	}
	
	public int setNumberColonne(){
		return 10;
	}
	public int setNumberLine(){
		return 10;
	}
	/**
	 * renvoit la longueur du plateau
	 * @return
	 */
	public int get_length(){
		return a_board.length;
	}
	/**
	 * renvoit la largeur du plateau
	 * @return
	 */
	public int get_width(){
		return a_board[0].length;
	}
	/**
	 * renvoit l'Element placé dans le plateau à la position (x,y)
	 * @param i_x
	 * @param i_y
	 * @return
	 */
	public Element get_element (int i_x, int i_y){
		return a_board[i_x][i_y];
	}
}

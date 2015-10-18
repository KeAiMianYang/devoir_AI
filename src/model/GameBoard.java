package model;

import exception.OutOfBoundException;

/**
 * classe representant le plateau de jeu
 * @author kork
 *
 */
public class GameBoard {
	protected Element [][] a_board;
	/* TODO
	+----------------- Y
	|
	|
	|
	|
	|
	X
	 */
	/**
	 * instancie le plateau de jeu
	 * @param i_x le nombre de lignes du plateau
	 * @param i_y le nombre de colonnes du plateau
	 */
	public GameBoard (int i_x, int i_y){
//		i_x = i_x > 10 ? i_x : 10; // si i_x > 10 alors i_x ne change pas, sinon i_x = 10
//		i_y = i_y > 10 ? i_y : 10; // idem
		
		a_board = new Element[i_x][i_y];
	}
	/**
	 * ajoute un joueur dans le tableau
	 * @param i_x la coordonnée x
	 * @param i_y la coordonnée x
	 * @param i_d la direction du vaisseau
	 * @return le joueur crée, null si un joueur n'a pas été crée
	 */
	public Player add_player (int i_x, int i_y, Direction i_d) /*throws OutOfBoundException*/{
		Ship o_ship = new Ship(this, i_x, i_y, i_d);
		Player o_player = new Player(o_ship, null); // TODO:TOCHANGE
		if((i_x < 0 || i_x > get_length()) || (i_y < 0 || i_y > get_width()))
//			throw new exception.OutOfBoundException(); // si on essaye de placer un robot en dehors du plateau
			return null;
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
	 * renvoit la largeur du tableau
	 * renvoit la longueur du plateau
	 * @return
	 */
	public int get_length(){
		return a_board.length;
	}
	/**
	 *  renvoit la largeur du tableau
	 * renvoit la largeur du plateau
	 * @return
	 */
	public int get_width(){
		return a_board[0].length;
	}
	/**
	 * renvoit l'Element selon le x et le y
	 * renvoit l'Element placé dans le plateau à la position (x,y)
	 * @param i_x
	 * @param i_y
	 * @return
	 */
	public Element get_element (int i_x, int i_y){
		return a_board[i_x][i_y];
	} // get_element()
	/**
	 * modifie le tableau avec le déplacement du vaiseau
	 * @param i_ship le vaiseau qui se déplace
	 * @param i_posX la nouvelle position X
	 * @param i_posY la nouvelle position Y
	 */
	public boolean move(Ship i_ship, int i_posX, int i_posY, Direction i_d) { //TODO modif direction
		// test si la case ciblée est vide
		if(i_posX < 0 || i_posX > get_length() -1 || i_posY < 0 || i_posY > get_width() -1){
			// si le X ou Y est en dehors du tableau
			return false;
		}
		if(get_element(i_posX, i_posY) != null){
			// si le la case ciblée possède déjà une erreur
			return false;
		}
		// modification du plateau
		int posX = i_ship.get_posX();
		int posY = i_ship.get_posY();
		// crée un mur à l'endroit où se trouvait le vaisseau
		a_board[posX][posY] = new Wall(this, posX, posY);
		// met à jour les coordonnée du vaisseau
		i_ship.set_posX(i_posX);
		i_ship.set_posY(i_posY);
		i_ship.set_direction(i_d);
		
		// déplace le vaisseau
		a_board[i_posX][i_posY] = i_ship;
		return true;
	} // move()
} // GameBoard

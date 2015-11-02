package model;

import java.util.ArrayList;

/**
 * Classe représentant l'algorithme de Dijkstra
 * @author kork
 *
 */
public class Dijkstra {
	protected int[][] a_board;
	protected int a_originX;
	protected int a_originY;
	
	
	/**
	 * instancie la classe
	 * @param i_board le tableau d'entier tiré de GameBoard
	 */
	public Dijkstra(int[][] i_board, Ship i_ship){
		a_board = i_board;
		a_originX = i_ship.get_posX();
		a_originY = i_ship.get_posY();
	}

	/**
	 * renvoit le tableau d'entiers
	 * @return
	 */
	public int[][] get_board(){
		return a_board;
	}
	
	public int get_originX(){
		return a_originX;
	}
	
	public int get_originY(){
		return a_originY;
	}
	
	/**
	 * algorithme principale, remplis le tableau d'entier
	 * de nombres derminant dans combien de tours chaque position du plateau peut être atteinte
	 */
	public void algorithm(){
		give_value_plateau(a_originX, a_originY, 1);
	}
	
	/**
	 * Le veritable algorithme, est récursif
	 * @param i_x
	 * @param i_y
	 * @param i_cout coût du prochain coup
	 */
	protected void give_value_plateau(int i_x, int i_y, int i_cout){
		
		DijkstraIterator ite = new DijkstraIterator(a_board, i_x, i_y);
		
		while(ite.hasNext()){
			int value =ite.next(); // on passe a la position suivante
			int posX = ite.get_new_posX(); // la nouvelle position
			int posY = ite.get_new_posY(); // idem
			if(i_cout < value && value != -1){ // si on a trouve un chemin plus court
				a_board[posX][posY] = i_cout; // on met a jour la valeur
				// on passe par ce chemin pour voir si on a d'autres chemins plus courts
				give_value_plateau(posX, posY, i_cout+1);
			}
		}
	} // dijkstra(int, int, int)
	
	/**
	 * compare deux plateaux de valeurs, et donne une valeur à ce scénario
	 * @assert les deux plateaux doivent être de la même taille
	 * @param i_d le plateau de valeurs adverse
	 * @return la valeur de ce plateau, à savoir le nombre de case que le joueur contrôle comparé à l'adversaire
	 */
	public int compare(Dijkstra i_d){
		// -ea si on veux lancer les asserts
		assert a_board.length == i_d.get_board().length && a_board[0].length == i_d.get_board()[0].length;
		
		int counter=0;
		int[][] enemyBoard = i_d.get_board();
		
		for(int i=1 ; i<a_board.length-1 ; ++i){
			for(int j=1 ; j<a_board[0].length-1 ; ++j){
				counter += (a_board[i][j] < enemyBoard[i][j]) ? 1 : 0;
				// TODO: qu'est-ce qu'on fait quand la case a la même valeur pour les deux joueurs?
				// pour l'instant elle vaut zero
			}
		}
		
		return counter;
	} // value_board(Dijkstra)
}

package model;

import java.util.ArrayList;
import java.util.Random;

import com.sun.corba.se.impl.orbutil.DenseIntMapImpl;

/**
 * Classe representant l'algorithme de Dijkstra
 * @author kork
 *
 */
public class Dijkstra {
	protected int[][] a_board;
	protected int a_originX;
	protected int a_originY;
	
	
	/**
	 * instancie la classe
	 * @param i_board le tableau d'entier tirÃ© de GameBoard
	 */
	public Dijkstra(int[][] i_board, Ship i_ship){
		a_board = i_board;
		a_originX = i_ship.get_posX();
		a_originY = i_ship.get_posY();
	}
	
	/**
	 * la methode à utiliser pour calculer l'heuristique
	 * @param i_gb le plateau de jeu dans l'état à tester
	 * @param i_s le vaisseau du joueur dont c'est le tour
	 * @param i_enemies la liste de tous les vaiseaux dans le jeu
	 * @return
	 */
	public static int heuristique(GameBoard i_gb, Ship i_s ,ArrayList<Ship> i_ships){
		int[][] currentBoard = i_gb.to_int();
		Dijkstra dPlayer = new Dijkstra(currentBoard, i_s);
		dPlayer.algorithm();
		int[][] enemyBoard = i_gb.to_int();
		for(Ship ship : i_ships){
			if(!(ship == i_s)){ // si ce n'est pas le vaisseau testé
				Dijkstra dEnemy = new Dijkstra(currentBoard, ship);
				dEnemy.algorithm();
				dEnemy.updateEnemyBoard(enemyBoard);
			}
		}
		
		return dPlayer.compare(enemyBoard);
		
//		Random r = new Random();
//		return r.nextInt(9)+1; // une valeur entre 1 et 10
	}

	/**
	 * met à jour le plateau pour ajouter les valeurs du joueur enemis (utile pour plus de 2 joueurs)
	 * @param enemyBoard le joueur enemy
	 */
	private void updateEnemyBoard(int[][] i_enemyBoard) {
		for(int i=1 ; i<i_enemyBoard.length-1 ; ++i){
			for(int j=1 ; j<i_enemyBoard[0].length-1 ; ++j){
				i_enemyBoard[i][j] = Math.min(i_enemyBoard[i][j], a_board[i][j]);
			}
		}
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
	 * de nombres derminant dans combien de tours chaque position du plateau peut Ãªtre atteinte
	 */
	public void algorithm(){
		give_value_plateau(a_originX, a_originY, 1);
	}
	
	/**
	 * Le veritable algorithme, est rÃ©cursif
	 * @param i_x
	 * @param i_y
	 * @param i_cout coÃ»t du prochain coup
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
	 * compare deux plateaux de valeurs, et donne une valeur Ã  ce scÃ©nario
	 * @assert les deux plateaux doivent Ãªtre de la mÃªme taille
	 * @param i_d le plateau de valeurs adverse
	 * @return la valeur de ce plateau, Ã  savoir le nombre de case que le joueur contrÃ´le comparÃ© Ã  l'adversaire
	 */
	public int compare(int[][] i_d){
		// -ea si on veux lancer les asserts
		assert a_board.length == i_d.length && a_board[0].length == i_d[0].length;
		
		int counter=0;
		
		for(int i=1 ; i<a_board.length-1 ; ++i){
			for(int j=1 ; j<a_board[0].length-1 ; ++j){
				counter += (a_board[i][j] < i_d[i][j]) ? 1 : 0;
				// TODO: qu'est-ce qu'on fait quand la case a la mÃªme valeur pour les deux joueurs?
				// pour l'instant elle vaut zero
			}
		}
		
		return counter;
	} // value_board(Dijkstra)
}

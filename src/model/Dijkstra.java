package model;
/**
 * Classe représentant l'algorithme de Dijkstra
 * @author kork
 *
 */
public class Dijkstra {
	private int[][] a_board;
	private int a_originX;
	private int a_originY;
	
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
//		int x=a_originX; // les positions qui vontchanger au fur est à mesure du programe
//		int y=a_originY;
//		while(!is_full()){
//			
//		}
		dijkstra(a_originX, a_originY, 1);
	}
	
	/**
	 * Le veritable algorithme, est récursif
	 * @param i_x
	 * @param i_y
	 * @param i_cout coût du prochain coup
	 */
	private void dijkstra(int i_x, int i_y, int i_cout){
		
	}
	
	/**
	 * teste si il reste des cases du tableau qui ne sont pas remplies
	 * @return
	 */
	public boolean is_full(){ //TODO: trouver un meilleur test pour savoir si le tableau est plein
		for(int i=0 ; i<a_board.length ; ++i){
			for(int j=0 ; j<a_board[0].length ; ++j){
				if(a_board[i][j] == 0)
					return false;
			}
		}
		return true;
	}
}

/**
 * BINOME : 
 * Dupuy-roudel Hugo : 21306151
 * Lebert Jasmine : 21301704
 */

package model;

import java.util.Iterator;

public class DijkstraIterator implements Iterator <Integer> {
	
	protected int[][] a_board;
	protected int a_posX;
	protected int a_posY;
	protected int a_counter;
	protected int a_newPosX;
	protected int a_newPosY;
	
	protected final int[][] a_deltas = {
			{0,1},
			{0,-1},
			{1,0},
			{-1, 0}
	};
	
	/**
	 * instancie l'itérateur utilisé par Dijkstra
	 * @param i_board le plateau de jeu en int[][]
	 * @param i_x la coordonnée X du joueur
	 * @param i_y la coordonnée Y du joueur
	 */
	public DijkstraIterator(int[][] i_board, int i_x, int i_y){
		a_board = i_board;
		a_posX = i_x;
		a_posY = i_y;
		a_counter = 0;
	}
	
	@Override
	public boolean hasNext() {
		return a_counter < a_deltas.length;
	}

	@Override
	public Integer next() {
		a_newPosX = a_posX + a_deltas[a_counter][0];
		a_newPosY = a_posY + a_deltas[a_counter][1];
		int o_value = a_board[a_newPosX][a_newPosY];
		
		++a_counter;
		return o_value;
	}
	
	public int get_new_posX(){
		return a_newPosX;
	}

	public int get_new_posY(){
		return a_newPosY;
	}

}

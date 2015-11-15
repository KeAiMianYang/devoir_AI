package devoir_AI;

import java.util.Iterator;

import model.*;

public class GameIterator implements Iterator<GameBoard> {
	
	protected Direction[] a_directions = {
			Direction.NORTH,
			Direction.WEST,
			Direction.SOUTH,
			Direction.EAST
	};
	protected GameBoard[] a_gameBoards;
	protected int a_currentDirection;
	
	public GameIterator(GameBoard i_gameBoard, Ship i_originalShip) {
		a_currentDirection = 0;
		a_gameBoards = new GameBoard[a_directions.length];
		for(int i=0 ; i<a_directions.length ; ++i){
			a_gameBoards[i] = i_gameBoard.copy();
		}
	}
//	public GameIterator() {
//		a_currentDirection = 0;
//	}

	@Override
	public boolean hasNext() {
		return a_currentDirection < a_directions.length-1; // tant que le curseur est inferieur à 3, c'est bon
	}
	
	public void reset_cursor(){
		a_currentDirection = 0;
	}

	@Override
	public GameBoard next() {
		//TODO
		return null;
	}

}

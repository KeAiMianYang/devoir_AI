package devoir_AI;
//test
import model.*;

public class Game {
	
	/**
	 * renvoit un plateau modifié après le déplacement du joueur
	 * @param p
	 * @param m
	 * @return
	 */
	public GameBoard play (Player p, Direction m){
		//calcul lié a L'IA
		
		// wall = p.setPosition
		//	p.move(m);
		
		return null;
	}
	
	/**
	 * renvoit vrai si le jeu est terminé, faux sinon (plateau en état terminal)
	 * @return
	 */
	public boolean terminal(){
		return false;
	}
	
	/**
	 * liste des états du plateau sur lequel peut arriver le joueur
	 * @param p le joueur
	 * @return
	 */
	public GameBoard[] next_move(Player p){

		return null;
	}

	/**
	 * renvoit la valeur d'un plateau selon le premier joueur
	 * @param g le plateau à étudier
	 * @return la valeur du plateau
	 */
	public int value(GameBoard g){
		return 0;
	}
}

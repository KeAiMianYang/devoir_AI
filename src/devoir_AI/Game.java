package devoir_AI;

import model.*;

public class Game {
	
	/**
	 * renvoit un plateau modifié après le déplacement du joueur
	 * @param p
	 * @param m
	 * @return
	 */
	public GameBoard play (Player p, Direction m, GameBoard g){
		//calcul lié a L'IA
		
		// wall = p.setPosition
		//	p.move(m);
		
		next_move(p,g);
		
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
	public GameBoard next_move(Player p,GameBoard g){
		GameBoard gNord = g.copy();// Copie pour le NORD
		GameBoard gSud = g.copy();//Copie pour le SUD		
		GameBoard gEst = g.copy();//Copie pour l'EST
		GameBoard gOuest = g.copy();//Copie pour l'OUEST
		
		//Il faut executer la méthode move du vaisseau dans les différents plateau
		gNord.getListShips(); 
		
		//Puis comparer les valeurs du plateau
		
		//Enfin retourner le meilleur plateau
		return null;
	}

	/**
	 * renvoit la valeur d'un plateau selon le premier joueur
	 * @param g le plateau à étudier
	 * @return la valeur du plateau
	 */
	public int value(GameBoard g){
		//Appel les méthodes dans Dijsktra pour avoir la valeur de l'heuristique
		return 0;
	}
}

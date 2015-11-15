package devoir_AI;

import java.util.HashMap;

import model.*;

public class Game {
	
	/**
	 * renvoit un plateau modifié après le déplacement du joueur
	 * @param p
	 * @param m
	 * @return
	 */
	// TODO: surement beaucoup sera à changer pour pouvoir envoyer un nouveau plateau
	public GameBoard play (Player i_p, GameBoard io_g){
		//calcul lié a L'IA
		
		// wall = p.setPosition
		//	p.move(m);
		Direction bestDirection = next_move(i_p,io_g);
		i_p.move(bestDirection);
		// il faut refaire bouger le vaisseau pour ne pas avoir de problème plus tard
		// les copies n'ont pas de joueurs liés
		
		return io_g;
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
	 * @return la meilleur direction à prendre
	 */
	public Direction next_move(Player p,GameBoard g){
		GameBoard gNord = g.copy();// Copie pour le NORD
		GameBoard gSud = g.copy();//Copie pour le SUD		
		GameBoard gEst = g.copy();//Copie pour l'EST
		GameBoard gOuest = g.copy();//Copie pour l'OUEST
		
		Ship originalShip = p.get_ship();
		
		// Il faut recuperer le vaisseau à déplacer dans chaque cas
		// est égal à null si aucun vaisseau trouvé
		Ship cpShipNorth = gNord.get_equivalent_ship(originalShip);
		Ship cpShipSouth = gSud.get_equivalent_ship(originalShip);
		Ship cpShipEast = gEst.get_equivalent_ship(originalShip);
		Ship cpShipWest = gOuest.get_equivalent_ship(originalShip);
		
		//Il faut bouger le vaisseau en question dans chaque direction
		boolean isAliveNorth = false;
		boolean isAliveSouth = false;
		boolean isAliveEast = false;
		boolean isAliveWest = false;
		try{
			isAliveNorth = cpShipNorth.move(Direction.NORTH);
			isAliveSouth = cpShipSouth.move(Direction.SOUTH);
			isAliveEast = cpShipEast.move(Direction.EAST);
			isAliveWest = cpShipWest.move(Direction.WEST);
		} catch (NullPointerException e){
			System.err.println("ERREUR : un des vaisseau présents dans les plateaux"
					+ "copiés n'a pas été trouvé");
			e.printStackTrace();
			System.exit(-1);
		}
		// Retourner la valeur du plateau pour chaque copy du plateau
		HashMap<Direction, Integer> heuristics = new HashMap<Direction, Integer>();
		
		//CAS NORD
		int heuristicNorth = -1;
		// on initialise l'heuristique au cas où le vaisseau crash
		if(isAliveNorth){
			System.out.println("cpShipNorth "+cpShipNorth);
			heuristicNorth = Dijkstra.heuristique(gNord, cpShipNorth);
		}
		heuristics.put(Direction.NORTH, heuristicNorth);
		// on attribut l'heuristique donnée
		
		//CAS SUD
		int heuristicSouth = -1;
		if(isAliveSouth){
			heuristicSouth = Dijkstra.heuristique(gSud, cpShipSouth);
		}
		heuristics.put(Direction.SOUTH, heuristicSouth);
		
		//CAS EST
		int heuristicEast = -1;
		if(isAliveEast){
			heuristicEast = Dijkstra.heuristique(gEst, cpShipEast);
		}
		heuristics.put(Direction.EAST, heuristicEast);
		
		//CAS OUEST
		int heuristicWest = -1;
		if(isAliveWest){//TODO: dans test, est mort, supposé?
			heuristicWest = Dijkstra.heuristique(gOuest, cpShipWest);
		}
		heuristics.put(Direction.WEST, heuristicWest);
		
		//Puis on compare les differentes heuristiques et on retourne la meilleur
		System.out.println(heuristics); // TODO:REMOVE
		//heuristique incorecte
		
		int bestValue=-2; // on s'assure qu'au moins une valeur est choisie
		Direction bestDirection = null;
		int currentHeuristic=0;
		currentHeuristic = heuristics.get(Direction.NORTH);
		if(bestValue < currentHeuristic){
			bestDirection = Direction.NORTH;
			bestValue = currentHeuristic;
		}
		
		currentHeuristic = heuristics.get(Direction.SOUTH);
		if(bestValue < currentHeuristic){
			bestDirection = Direction.SOUTH;
			bestValue = currentHeuristic;
		}

		currentHeuristic = heuristics.get(Direction.EAST);
		if(bestValue < currentHeuristic){
			bestDirection = Direction.EAST;
			bestValue = currentHeuristic;
		}

		currentHeuristic = heuristics.get(Direction.WEST);
		if(bestValue < currentHeuristic){
			bestDirection = Direction.WEST;
			bestValue = currentHeuristic;
		}
		
		return bestDirection;
		
	} // next_move(Player, GameBoard) : GameBoard

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

package view;

import java.util.Scanner;

import model.*;
/**
 * Représente le jeu en format texte.
 * @author kork
 *
 */
//TODO:NOT TESTED
public class TextView {
	protected GameBoard a_boardModel = null;
	protected char[][] a_boardView = null;
	/**
	 * instancie le tableau utilisé pour afficher le jeu
	 * @param i_g le plateau de jeu crée auparavant
	 */
	public TextView(GameBoard i_g){
		a_boardView = new char[i_g.get_length()][i_g.get_width()];
		a_boardModel = i_g;
		update();
	} // TextView(GameBoard)
	/**
	 * met à jour la représentation du plateau visuel en fonction du plateau modele
	 */
	public void update(){
		char icon = 0;
		for(int i=0 ; i<a_boardView.length ; i++){
			for(int j=0 ; j<a_boardView[0].length ; j++){
				if(a_boardModel.get_element(i, j) instanceof Ship)
					icon = 'S';
				else if(a_boardModel.get_element(i, j) instanceof Wall)
					icon = 'W';
				
				a_boardView[i][j] = icon;
			}
		}
	} // update()
	/**
	 * affiche sur la sortie standard le plateau de jeu
	 */
	public void display(){
		update();
		System.out.print("   ");
		for(int x=0 ; x<a_boardView[0].length ; x++){
			System.out.print("("+x+")"); // affiche les numéros de colonnes
		}
		System.out.println();
		
		for(int i=0 ; i<a_boardView.length ; i++){
			System.out.print("("+i+")"); // affiche les numéros de lignes
			for(int j=0 ; j<a_boardView[0].length ; j++){
				Element e = a_boardModel.get_element(i, j);
				System.out.print("[");
				if(e == null)
					System.out.print(" ");
				else if(e instanceof Ship)
					System.out.print("p");
				else if(e instanceof Wall)
					System.out.print("w");
				System.out.print("]");
			}
			System.out.println();
		}
		System.out.println();
	} // display()
	/**
	 * affichage simplifié se contentant d'afficher une liste des cases remplies,
	 * et de leurs données
	 */
	public void display_simple(){
		for (int i=0; i< a_boardModel.get_length(); i++ ){
			for(int j=0; j<a_boardModel.get_width(); j++){
				if(a_boardModel.get_element(i, j) == null) continue; //TOREMOVE
				System.out.println("x="+i+" y="+j+" -> "+a_boardModel.get_element(i,j));
			}
		}
	} // display_simple()
	
	/**
	 * demande à l'utilisateur de creer un joueur
	 * @param i_pNum
	 * @param i_maxX
	 * @param i_maxY
	 */
	public static void text_create_player(int i_pNum, int i_maxX, int i_maxY){
		System.out.println("entrées les coordonnées du joueur "+i_pNum+" et sa direction\n"
				+ "dans la forme 'position_x position_y direction',\n"
				+ "les coordonnées peuvent se situer:\n"
				+ "\tentre 0 et "+i_maxX+" pour les X et 0 et "+i_maxY+" pour les Y\n"
				+ "la direction peux soit être:\n\t'N' pour Nord,\t'S' pour Sud,\t'O' pour Ouest"
				+ ",\t'E' pour Est");
	}
	 /**
	  * demande les characteristiques du joueur
	  * @param i
	  * @param j
	  * @return null si le joueur ne peux pas être crée
	  */
	public static String[] text_enter_player(Scanner i_sc, int i_maxX, int i_maxY) {
		String[] p = new String[3];
		int[] tmp = new int[2];
		tmp[0] = i_sc.nextInt();
		tmp[1] = i_sc.nextInt();
		p[0] = String.valueOf(tmp[0]);
		p[1] = String.valueOf(tmp[1]);
		p[2] = i_sc.next();
		
		if(tmp[0] <= i_maxX && tmp[0] >= 0 && tmp[1] <= i_maxY && tmp[1] >= 0
				&& (p[2].equals("N") || p[2].equals("S") || p[2].equals("O") || p[2].equals("E")))
			return p;
		return null;
	}
	public static String choose(Scanner sc) {
		String entry = "";
		while(!entry.equals("p") && !entry.equals("s")){
			System.out.println("tappez 'p' si vous voulez ajouter un joueur,"
					+ "'s' si vous voulez lancer la partie"
					+ "(vous ne pouvez pas lancer la partie avec moins de 2 joueurs");
			entry = sc.next();
		}
		return entry;
	}
} // TextView

package view;

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
} // TextView

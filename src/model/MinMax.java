package model;

import org.w3c.dom.Node;

/**
 * algorithme minmax avec élagage alpha-beta

 * @author Jasmine
 *
 */
public class MinMax {
	protected int m;
	public MinMax(){
		
	}
	/*Algo du cours :
	 if d = 0 then
		 return f (ei )
	 else
		 if ei est un noeud joueur then
			 m ← −∞ 
			 for all ej ∈ successeurs(ei ) do
				m ← max(m, minimax(ej , d − 1))
			end for
		 else
		    m ← +∞ 
		    for all ej ∈ successeurs(ei ) do
				m ← min(m, minimax(ej , d − 1))
			end for
		end if
	  	return m
	end if */
	public int minimax(Node ei, int d){
	
		if(d == 0){
			return f(ei);
		}
		else {
			if(estNoeudJoueur(ei)){ //ei est un noeud joueur? 
				 m = -10000000;//Remplace moins l'infini
				 for(int i=0; i< ei.getChildNodes().getLength(); i++){ //for all ej ∈ successeurs(ei ) do
					 Node ej = ei.getParentNode();//successeur = noeud parent
					 m = max(m,minimax(ej,(d-1)));
				 }
			}
			else{
				m = 10000000;
				for(int i=0; i< ei.getChildNodes().getLength(); i++){ //for all ej ∈ successeurs(ei ) do
					 Node ej = ei.getParentNode();//successeur = noeud parent
					 m = min(m,minimax(ej,(d-1)));
				 }
			}
			return m;
		}
	}
	/**
	 * Cette méthode test si le noeud appartient au joueur ou non
	 * @param noeud
	 * @return
	 */
	public boolean estNoeudJoueur(Node noeud){
		return true;
	}
	/**
	 * 
	 * @param chiffre1
	 * @param chiffre2
	 * @return le plus petit chiffre
	 */
	public int min(int chiffre1, int chiffre2) {
		if(chiffre1 > chiffre2){
			return chiffre2;
		}
		else{
			return chiffre1;
		}
	}
	/**
	 * 
	 * @param chiffre1
	 * @param chiffre2
	 * @return le plus grand chiffre
	 */
	public int max(int chiffre1, int chiffre2) {
		if(chiffre1 > chiffre2){
			return chiffre1;
		}
		else{
			return chiffre2;
		}
	}
	
	/**
	 * fonction f
	 * @param ei
	 * @return
	 */
	public int f(Node ei){
		return 0;
		
	}
}

package model;
/**
 * Classe representant un joueur
 */
public class Player {
	protected Ship a_ship; // representation du joueur sur le plateau
	protected AI a_ai; // l'intelligence du vaiseau
	public int x, y;//position de la moto sur la grille
	public String a_name = "P1";
	protected boolean a_win = false; // false : partie en cours. true : a gagner
	public boolean a_lost = false; // false : partie en cours; true : a perdu
	/**
	 * Instanciation du joueur
	 * @param i_ship
	 * @param i_ai
	 */
	public Player(Ship i_ship, AI i_ai){
		a_ship = i_ship;
		a_ai = i_ai;
		
	}
	/**
	 * retourne la moto representant le joueur
	 * @return
	 */
	public Ship get_ship() {
		return a_ship;
	}
	/**
	 * modifie  la moto representant le joueur
	 * @param a_ship
	 */
	public void set_ship(Ship a_ship) {
		this.a_ship = a_ship;
	}
	/**
	 * retourne IA suivie par le joueur
	 * @return
	 */
	public AI get_ai() {
		return a_ai;
	}
	/**
	 * modifie IA suivie par le joueur
	 * @param a_ai
	 */
	public void set_ai(AI a_ai) {
		this.a_ai = a_ai;
	}
	/**
	 * Modifie la position du joueur
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**
	 * bouge le joueur
	 */
	public void move(Direction a_direction){
		//Le joueur ne pourra pas se deplacer s'il a perdu
		if(a_lost != true){
			if(!a_ship.move(a_direction)){
				a_lost = true;
			}
		}
			
	}
	public void win(){
		
	}
	/**
	 * renvoit les coordonnées et la direction d'un vaisseau dans une chaine de caracteres
	 */
	@Override
	public String toString(){
		return a_ship.toString()+" direction="+a_ship.get_direction();
	}
}

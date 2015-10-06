package model;

public class Player {
	protected Ship a_ship; // representation du joueur sur le plateau
	protected AI a_ai; // l'intelligence du vaiseau
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
	 * @return
	 */
	public Ship get_ship() {
		return a_ship;
	}
	/**
	 * @param a_ship
	 */
	public void set_ship(Ship a_ship) {
		this.a_ship = a_ship;
	}
	/**
	 * @return
	 */
	public AI get_ai() {
		return a_ai;
	}
	/**
	 * @param a_ai
	 */
	public void set_ai(AI a_ai) {
		this.a_ai = a_ai;
	}
	
	
}
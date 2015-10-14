package devoir_AI;
import model.*;
import view.*;
public class mainClass {

	public static void main(String[] args) {
		
		GameBoard gb = new GameBoard(3, 6);
		TextView tv = new TextView(gb);
		
		
		Player p = gb.add_player(2, 3, Direction.NORTH);
		display_null(gb);
		System.out.println("\nAffichage visuel:");
//		display(gb);
		tv.display();
		
		p.move(Direction.NORTH);
		
//		display(gb);
		tv.display();
		
		p.move(Direction.EAST);
		
//		display(gb);
		tv.display();
		
	} // Main(String[])
	/**
	 * affiche de façon ZOLIE
	 * @param i_g le plateau de jeu
	 */
	public static void display(GameBoard i_g){
		System.out.print("   ");
		for(int x=0 ; x<i_g.get_width() ; x++){
			System.out.print("("+x+")");
		}
		System.out.println();
		
		for(int i=0 ; i<i_g.get_length() ; i++){
			System.out.print("("+i+")");
			for(int j=0 ; j<i_g.get_width() ; j++){
				Element e = i_g.get_element(i, j);
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
	} // display(GameBoard)
	/**
	 * affiche juste une liste des cases
	 * @param i_g le plateau de jeu
	 */
	public static void display_null(GameBoard i_g){
		for (int i=0; i< i_g.get_length(); i++ ){
			for(int j=0; j<i_g.get_width(); j++){
				if(i_g.get_element(i, j) == null) continue; //TOREMOVE
				System.out.println("x="+i+" y="+j+" -> "+i_g.get_element(i,j));
			}
		}
	} // display_null(GameBoard)

}

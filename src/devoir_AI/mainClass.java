package devoir_AI;
import exception.OutOfBoundException;
import model.*;
import view.*;
public class mainClass {

	public static void main(String[] args) {
		GameBoard gb = new GameBoard(3, 6);
		TextView tv = new TextView(gb);
		Player p = gb.add_player(0, 1, Direction.WEST);
		Player p2 = gb.add_player(2, 5, Direction.EAST);
		
		
		while( p.a_lost == false && p2.a_lost == false ){
			tv.display();
			p.move(Direction.EAST);
			p2.move(Direction.WEST);
			tv.display();
		}
		if(p.a_lost == false){
			System.out.println("P a gagné");
		}
		if(p2.a_lost == false){
			System.out.println("P2 a gagné");
		}
		/*tv.display();
		
		p2.move(Direction.WEST);
		
		tv.display();
		
		p2.move(Direction.SOUTH);
		
		tv.display();
		
		p2.move(Direction.NORTH);
		
		tv.display();*/
	} // Main(String[])

}

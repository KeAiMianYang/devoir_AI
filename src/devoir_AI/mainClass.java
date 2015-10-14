package devoir_AI;
import exception.OutOfBoundException;
import model.*;
import view.*;
public class mainClass {

	public static void main(String[] args) {
		GameBoard gb = new GameBoard(3, 6);
		TextView tv = new TextView(gb);
		Player p = gb.add_player(5, 5, Direction.NORTH);
		Player p2 = gb.add_player(2, 5, Direction.EAST);
		
		tv.display();
		
		p2.move(Direction.WEST);
		
		tv.display();
		
		p2.move(Direction.SOUTH);
		
		tv.display();
		
	} // Main(String[])

}

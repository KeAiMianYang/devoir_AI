package devoir_AI;
import exception.OutOfBoundException;
import model.*;
import view.*;
public class mainClass {

	public static void main(String[] args) throws InterruptedException {
		GameBoard gb = new GameBoard(3, 6);
		TextView tv = new TextView(gb);
		Player p = gb.add_player(0, 1, Direction.WEST);
		Player p2 = gb.add_player(2, 5, Direction.EAST);
		Game game = new Game();
		
		do{
			game.play(p,gb);
//			game.next_move(p2,gb);
			tv.display();
			Thread.sleep(2000); // c'est en millisecondes
		}while( p.get_isAlive() == true && p2.get_isAlive() == true );
		
		
		if(p.get_isAlive() == true){
			System.out.println("P a gagné");
		}
		if(p2.get_isAlive() == true){
			System.out.println("P2 a gagné");
		}
		
	/*	GameBoard gNord = gb.copy();
		System.out.println(gNord.getListShips()+" "+gb.getListShips());
		
		TextView tv2 = new TextView(gNord);
		tv2.display();
		
		/*tv.display();
		
		p2.move(Direction.WEST);
		
		tv.display();
		
		p2.move(Direction.SOUTH);
		
		tv.display();
		
		p2.move(Direction.NORTH);
		
		tv.display();*/
		
		
	} // Main(String[])

}

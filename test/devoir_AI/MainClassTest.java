package devoir_AI;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Direction;
import model.GameBoard;
import model.Player;
import view.TextView;

public class MainClassTest {

	@Test
	public void test_2_joueurs() throws InterruptedException{
		GameBoard gb = new GameBoard(3, 6);
		TextView tv = new TextView(gb);
		Player p = gb.add_player(0, 1, Direction.WEST);
		Player p2 = gb.add_player(2, 5, Direction.EAST);
		Game game = new Game();
		
		tv.display();
		Thread.sleep(1000);
		while( p.get_isAlive() == true && p2.get_isAlive() == true ){
			game.play(p,gb);
			game.play(p2,gb);
			tv.display();
			Thread.sleep(1000); // c'est en millisecondes
		}
		
		
		if(p.get_isAlive() == true){
			System.out.println("P a gagné");
		}
		if(p2.get_isAlive() == true){
			System.out.println("P2 a gagné");
		}
	}
	
	@Test
	public void test_3_joueurs() throws InterruptedException{
		GameBoard gb = new GameBoard(6, 6);
		TextView tv = new TextView(gb);
		Player p = gb.add_player(0, 1, Direction.WEST);
		Player p2 = gb.add_player(2, 5, Direction.EAST);
		Player p3 = gb.add_player(4, 3, Direction.SOUTH);
		Game game = new Game();
		
		tv.display();
		Thread.sleep(1000);
		while( p.get_isAlive() == true && p2.get_isAlive() == true && p3.get_isAlive()){
			game.play(p,gb);
			game.play(p2,gb);
			game.play(p3,gb);
			tv.display();
			Thread.sleep(1000); // c'est en millisecondes
		}
		
		
		if(p.get_isAlive() == true){
			System.out.println("P a gagné");
		}
		if(p2.get_isAlive() == true){
			System.out.println("P2 a gagné");
		}
		
		if(p3.get_isAlive() == true){
			System.out.println("P3 a gagné");
		}
	}

}

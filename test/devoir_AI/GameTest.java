package devoir_AI;

import static org.junit.Assert.*;

import org.junit.*;

import model.*;

public class GameTest {
	
	public static GameBoard a_gb = null; 
	
	@BeforeClass
	public static void before_class(){
		a_gb = new GameBoard(5, 4);
		a_gb.add_player(3, 2, Direction.SOUTH);
		a_gb.add_player(1, 3, Direction.EAST);
	}
	
	@Test
	public void test_next_move(){
		
	}
}

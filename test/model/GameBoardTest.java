package model;

import static org.junit.Assert.*;

import org.junit.*;

public class GameBoardTest {
	
	GameBoard a_gb;
	
	@Before
	public void before(){
		a_gb = new GameBoard(6, 4);
	}

	@Test
	public void test_to_int() {
		Player p = a_gb.add_player(3, 2, Direction.NORTH);
		Player p2 = a_gb.add_player(2, 1, Direction.EAST);
		
		int[][] o_gb = a_gb.to_int();
		
		assertEquals(0, o_gb[2][2]); // test si une case est vide
		assertEquals(-1, o_gb[4][3]); // test si il y a un vaisseau
		assertEquals(-1, o_gb[3][2]); // idem
		
		p.move(Direction.NORTH);
		o_gb = a_gb.to_int();
		
		assertEquals(-1, o_gb[4][3]); // test si il y a un mur
		assertEquals(-1, o_gb[3][3]); // test si le vaisseau a bougé
	}

}

package model;

import static org.junit.Assert.*;

import org.junit.*;

public class DijkstraTest {
	
	static Dijkstra a_d;
	static GameBoard gb;
	
	@BeforeClass
	public static void before_class(){
		gb = new GameBoard(5, 6);
	}
	
	@Before
	public void before(){
		Player p = gb.add_player(3, 2, Direction.NORTH);
		p.move(Direction.NORTH);
		
		a_d = new Dijkstra(gb.to_int(), p.get_ship());
	}

	@Test
	public void test_() {
		
	}

}

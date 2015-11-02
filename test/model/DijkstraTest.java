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
	public void test_algorithm() {
		disp(a_d.get_board());
		a_d.algorithm();
		int[][] newBoard = a_d.get_board();
		disp(newBoard);
	}
	
	public void disp(int[][] newBoard){
		for(int i=0 ; i<newBoard.length ; ++i){
			for(int j=0 ; j<newBoard[0].length ; ++j){
				System.out.print("["+newBoard[i][j]+"]");
			}
			System.out.println();
		}
	}

}

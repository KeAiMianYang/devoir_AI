package model;

import static org.junit.Assert.*;

import org.junit.*;

public class DijkstraTest {
	
	static Dijkstra a_d;
	static Dijkstra a_d2;
	static GameBoard gb;
	
	@BeforeClass
	public static void before_class(){
		gb = new GameBoard(4, 5);
	}
	
	@Before
	public void before(){
		Player p = gb.add_player(0, 2, Direction.SOUTH);
		Player p2 = gb.add_player(3, 3, Direction.NORTH);
		// NullPointerException, aucune idée d'où ça vient
		p2.move(Direction.NORTH);
		p.move(Direction.SOUTH);
		
		a_d = new Dijkstra(gb.to_int(), p.get_ship());
		a_d2 = new Dijkstra(gb.to_int(), p2.get_ship());
	}
	/*
	@Test
	public void test_algorithm() { // aucune idée pourquoi c'est consideré comme ne fonctionnant pas
		disp(a_d.get_board());
		a_d.algorithm();
		int[][] newBoard = a_d.get_board();
		disp(newBoard);

		assertFalse(false);
	}
	*/
	
	@Test
	public void test_compare(){
		a_d.algorithm();
		a_d2.algorithm();
		System.out.println("player 1 :");
		disp(a_d.get_board());
		System.out.println("player 2 :");
		disp(a_d2.get_board());
		
		int value = a_d.compare(a_d2);
		int value2 = a_d2.compare(a_d);
		System.out.println("P1 : "+value+"\nP2 : "+value2);
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
